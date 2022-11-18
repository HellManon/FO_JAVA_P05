import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireStationController {
	
	//@GetMapping("/firestation?stationNumber=<station_number>")
	@GetMapping("/firestation")
	public String stationNumber (){
		return "station number";
	}
	
	@GetMapping("/phoneAlert?firestation=<firestation_number>")
	public String firestationNumber (){
		return "firestation number";
	}
	
	@GetMapping("/flood/stations?stations=<a list of station_numbers>")
	public String ListOfStationNumber (){
		return "List of station number ";
	}
	
}