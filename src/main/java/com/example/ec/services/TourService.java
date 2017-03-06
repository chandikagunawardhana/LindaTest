package main.java.com.example.ec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.example.ec.domain.Difficulty;
import main.java.com.example.ec.domain.Region;
import main.java.com.example.ec.domain.Tour;
import main.java.com.example.ec.domain.TourPackage;
import main.java.com.example.ec.repo.TourPackageRepository;
import main.java.com.example.ec.repo.TourRepository;

@Service
public class TourService {
	
	private TourPackageRepository tourPackageRepository;
	private TourRepository tourRepository;
	
	@Autowired
	public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
		this.tourPackageRepository = tourPackageRepository;
		this.tourRepository = tourRepository;
	}
	
	public Tour createTour (String title, String description, String blurb, Integer price, String duration, String bullets,
			String keywords, String tourPackageName, Difficulty difficulty, Region region) {
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
		if (tourPackage == null) {
			throw new RuntimeException("Tour package does not exist:" + tourPackageName);
		}
		return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
	}
	
	public Iterable<Tour> lookup() {
		return tourRepository.findAll();
	}
	
	public long total() {
		return tourRepository.count();
	}
}
