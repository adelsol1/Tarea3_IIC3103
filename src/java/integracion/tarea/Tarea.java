/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.tarea;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author aliciadelsol
 */
@WebService(serviceName = "Tarea")
public class Tarea {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerInfo")
    public String[] obtenerInfo(@WebParam(name = "pais") String pais) {
        String[] result = new String[2];
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gws = gw.getGlobalWeatherSoap();
        Airport a = new Airport();
        AirportSoap as = a.getAirportSoap();
        result[0]= gws.getCitiesByCountry(pais);
        result[1]=as.getAirportInformationByCountry(pais);
        
        return result;
    }
}
