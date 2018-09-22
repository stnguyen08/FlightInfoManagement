package cs544.flight.service.impl;

import java.util.List;

import cs544.flight.model.FlightInfo;
import cs544.flight.repository.FlightRepository;
import cs544.flight.service.IFlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carOwnerService")
public class FlightInfoService implements IFlightInfoService {

	@Autowired
    FlightRepository carOwnerRepository;
	
	@Override
	public List<FlightInfo> findAll() {
		//return carOwnerRepository.findAll();
		return carOwnerRepository.findAll();
	}

	@Override
	public FlightInfo save(FlightInfo carOwner) {
		return carOwnerRepository.save(carOwner);
	}

	@Override
	public FlightInfo findOne(Long id) {
		return carOwnerRepository.findOne(id);
		//return carOwnerRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		carOwnerRepository.delete(id);
		//carOwnerRepository.deleteById(id);
	}

}
