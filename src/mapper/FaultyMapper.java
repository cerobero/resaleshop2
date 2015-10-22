package mapper;

import java.util.List;

import vo.Faulty;

public interface FaultyMapper {
	public int writeFaulty(Faulty faulty);
	public List<Faulty> selectArticleFaulty(int articleNo);
	public Faulty selectFaultyview(int faultyNo);
	public int selectArticleFaultyNumber(int articleNo);
	public int reWriteFaulty(Faulty faulty);
	public int cancelFaulty(int faultyNo);
}
