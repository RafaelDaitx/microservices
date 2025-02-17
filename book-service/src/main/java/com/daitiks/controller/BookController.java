package com.daitiks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import com.daitiks.model.Book;
import com.daitiks.proxy.CambioProxy;
import com.daitiks.repository.BookRepository;
import com.daitiks.response.Cambio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository repository;

	@Autowired
	private CambioProxy cambioProxy;
	
//	@GetMapping(value = "/{id}/{currency}")
//	public Book findBook(
//			@PathVariable("id") Long id,
//			@PathVariable("currency") String currency
//			) {
//		var book = repository.findById(id);
//		if(book == null) throw new RuntimeException("Book not found!");
//		
//		
//		HashMap<String,String> params = new HashMap<>();
//		params.put("amount", book.get().getPrice().toString());
//		params.put("from","USD");
//		params.put("to", currency);
//		
//		var response = new RestTemplate().getForEntity("http://localhost/8000/cambio-service/{amount}/{from}/{to}", Cambio.class, params);
//		var cambio = response.getBody();
//		
//		var port = environment.getProperty("local.server.port");
//		book.get().setEnvironment(port);
//		book.get().setPrice(cambio.getConvertedValue());
//		return new Book(1L, book.get().getAuthor(), book.get().getTitle(), book.get().getLaunchDate(), book.get().getPrice(), book.get().getCurency(), port);
//	}
	
	@Operation(summary = "Find a specific book by your ID.")
	@GetMapping(value = "/{id}/{currency}")
	public Optional<Book> findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		var book = repository.findById(id);
		if(book == null) throw new RuntimeException("Book not found!");
		
		var cambio = cambioProxy.getCambio(book.get().getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		book.get().setEnvironment("Book port "+ port + ", Cambio Port " + cambio.getEnviroment());
		book.get().setPrice(cambio.getConvertedValue());
		return book;
	}
}
