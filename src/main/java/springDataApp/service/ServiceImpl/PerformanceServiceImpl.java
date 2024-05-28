package springDataApp.service.ServiceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springDataApp.dao.entities.Performance;
import springDataApp.dao.repositories.IPerformanceRepo;
import springDataApp.service.IService.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService{

	private  IPerformanceRepo performanceRepository;

    @Override
    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    @Override
    public Performance getPerformanceById(int id) {
        Optional<Performance> performance = performanceRepository.findById(id);
        return performance.orElse(null);
    }

    @Override
    public void addPerformance(Performance performance) {
        performanceRepository.save(performance);
    }

    @Override
    public void updatePerformance(Performance performance) {
        performanceRepository.save(performance);
    }

    @Override
    public void deletePerformance(int id) {
    	performanceRepository.deleteById(id);
    }

}