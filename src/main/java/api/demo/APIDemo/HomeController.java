package api.demo.APIDemo;

import java.util.ArrayList;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import api.demo.APIDemo.model.Person;
import api.demo.APIDemo.model.Quote;
import api.demo.APIDemo.model.Result;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		mv.addObject("quotetest", quote);
		return mv;
	}

	@RequestMapping("/people")
	public ModelAndView people() {
		ModelAndView mv = new ModelAndView("personselect");
		// this code is to make sure we are connecting to the API

		// these lines are needed for https
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		// need to pass in the request factory to the RestTemplate
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		Result result = restTemplate.getForObject("https://swapi.co/api/people/?format=json", Result.class);
		System.out.println(result.toString());

		ArrayList<Person> people = result.getResult();

		for (Person p : people) {
			System.out.println(p.getName());
		}

		return mv;
	}

	// @RequestMapping(value="/personspecs", method = RequestMethod.POST)
	@PostMapping("/personspecs")
	public ModelAndView specs(@RequestParam("person") int num) {
		// these lines are needed for https
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		// need to pass in the request factory to the RestTemplate
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		Person result = restTemplate.getForObject("https://swapi.co/api/people/" + num+ "/?format=json", Person.class);
		return new ModelAndView("personresults", "person", result);
	}

}
