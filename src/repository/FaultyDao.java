package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FaultyMapper;
import vo.Faulty;

@Component
public class FaultyDao {
	private FaultyMapper mapper;
	
	@Autowired
	public FaultyDao(SqlSessionTemplate sessionTemplate){
		mapper=sessionTemplate.getMapper(FaultyMapper.class);
	}
	
	public int write(Faulty faulty){
		return mapper.writeFaulty(faulty);
	}
	
	public List<Faulty> listView(int articleNo){
		return mapper.selectArticleFaulty(articleNo);
	}
	
	public int faultyNumber(int articleNo){
		return mapper.selectArticleFaultyNumber(articleNo);
	}
	
	public int reWrite(Faulty faulty){
		return mapper.reWriteFaulty(faulty);
	}
	
	public Faulty read(int faultyNo){
		return mapper.selectFaultyview(faultyNo);
	}
	
	public int cancel(int faultyNo){
		return mapper.cancelFaulty(faultyNo);
	}
	
}
