package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.AuctionService;
import vo.Auction;
import vo.Bid;
import vo.PostFile;

@Controller
public class AuctionController
{
	private AuctionService service;
	
	@Autowired
	public void setService(AuctionService service)
	{
		this.service = service;
	}
	
	@RequestMapping("auctionList.do")
	public ModelAndView serviceAuctionList(	@RequestParam(defaultValue="") String search,
											@RequestParam(defaultValue="1") int page)
	{
		ModelAndView modelAndView = new ModelAndView("auction_list");
		
		modelAndView.addObject("somePage", service.getAuctionPage(search, page));
		
		return modelAndView;
	}
	
	@RequestMapping("auction.do")
	public ModelAndView serviceAuction(@RequestParam(defaultValue="1") int auctionNo)
	{
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView("auction");
		modelAndView.addAllObjects(service.readAuction(auctionNo));
		
		return modelAndView;
	}
	
	@RequestMapping(value="bid.do", method=RequestMethod.POST)
	public ModelAndView postBid(RedirectAttributes redirectAttributes, HttpSession session, Bid bid,
	    @RequestParam(required = false) String page, @RequestParam(required = false) String search)
	{
		ModelAndView modelAndView = null;
		
		bid.setBidder((String)session.getAttribute("id"));
		bid.setBidDate(new Date());
		
		if (!service.bidding(bid))
		{
			redirectAttributes.addFlashAttribute("errMsg", "입찰에 실패했습니다.");
		}
		else
		{
			redirectAttributes.addFlashAttribute("errMsg", "입찰에 성공했습니다.");
		}
		
		modelAndView = new ModelAndView("redirect:auction.do");
		modelAndView.addObject("auctionNo", bid.getAuctionNo());
		modelAndView.addObject("page", page);
		modelAndView.addObject("search", search);
		
		return modelAndView;
	}
	
	@RequestMapping(value="auctionWrite.do", method=RequestMethod.GET)
	public ModelAndView getAuctionWrite()
	{
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView("auction_write");
		
		return modelAndView;
	}
	
	@RequestMapping(value="auctionWrite.do", method=RequestMethod.POST)
	public ModelAndView postAuctionWrite(RedirectAttributes redirectAttributes, HttpSession session, Auction auction, PostFile file, String localEndDate)
	{
		ModelAndView modelAndView = null;
		
		localEndDate.replace("T", " ");

		auction.setUserId((String)session.getAttribute("id"));
		auction.setPostingDate(new Date());
		try
		{
			auction.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(localEndDate.replace("T", " ")));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		if (file.getFile() != null)
		{
			String folderPath = "c:/uploaded_file";
			File dir = new File(folderPath);

			if (!dir.exists())
			{
				dir.mkdirs();
			}

			String filePath = folderPath + "/" + new Random().nextInt(1000000);
			File savedFile = new File(filePath);

			try
			{
				file.getFile().transferTo(savedFile);
				auction.setPhoto(savedFile.getAbsolutePath());

				if (service.writeAuction(auction))
				{
					modelAndView = new ModelAndView("redirect:auction.do");
					modelAndView.addObject("auctionNo", auction.getAuctionNo());
				}
				else
				{
					modelAndView = new ModelAndView("redirect:auctionWrite.do");
					redirectAttributes.addFlashAttribute("errMsg", "입력값이 올바르지 않습니다.");
				}
			}
			catch (IllegalStateException e)
			{
				e.printStackTrace();
				modelAndView = new ModelAndView("redirect:auctionWrite.do");
				redirectAttributes.addFlashAttribute("errMsg", "입력값이 올바르지 않습니다.");
			}
			catch (IOException e)
			{
				e.printStackTrace();
				modelAndView = new ModelAndView("redirect:auctionWrite.do");
				redirectAttributes.addFlashAttribute("errMsg", "입력값이 올바르지 않습니다.");
			}
		}
		else
		{
			modelAndView = new ModelAndView("redirect:auctionWrite.do");
			redirectAttributes.addFlashAttribute("errMsg", "입력값이 올바르지 않습니다.");
		}
		
		return modelAndView;
	}
}
