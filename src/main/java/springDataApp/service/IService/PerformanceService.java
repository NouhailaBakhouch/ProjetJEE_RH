package springDataApp.service.IService;

import java.util.List;

import springDataApp.dao.entities.Performance;

public interface PerformanceService {
	List<Performance> getAllPerformances();
    Performance getPerformanceById(int id);
    void addPerformance(Performance performance);
    void updatePerformance(Performance performance);
    void deletePerformance(int id);

}
