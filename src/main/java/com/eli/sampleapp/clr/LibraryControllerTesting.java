package com.eli.sampleapp.clr;

import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.beans.BooksResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.apache.bcel.util.ClassLoaderReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class LibraryControllerTesting implements CommandLineRunner {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "http://localhost:8080/lib/";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setName("my bookkkkkkk");
        b1.setYear(2016);

        System.out.println(restTemplate.postForEntity(BASE_URL+"add-book", b1, String.class));


//		Book[] res = restTemplate.getForObject(BASE_URL+"get-books/2016", Book[].class);
//		System.out.println(Arrays.toString(res));

//        ResponseEntity<String> res = restTemplate.getForEntity(BASE_URL+"get-books/2016", String.class);
//		System.out.println(res);
//
//		String mybody = res.getBody();
//
//		List<Book> myBooks = objectMapper.readValue(mybody, BooksResponse.class);
    }

}