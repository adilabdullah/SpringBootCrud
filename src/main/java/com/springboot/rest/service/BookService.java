package com.springboot.rest.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.rest.model.*;

@Component
public class BookService {

	static List<Book> lis=new ArrayList<Book>();
	
	static {
		lis.add(new Book(734,"Adil","Java",231.23));
		lis.add(new Book(453,"Bilal","HTM:",452.65));
		lis.add(new Book(124,"Salman","C#",643.54));
		lis.add(new Book(241,"Noman","Puthon",134.34));
		lis.add(new Book(376,"Imran","PHP",652.21));  
	}
	
	public List<Book> getAllBooks()
	{
		return lis;
	}
	
	public Book getSpecificBook(int id)
	{
		int flag=0;
		Book bok=null;
	//	return lis.stream().filter(e->e.getId()==id).findFirst().get();
		for(Book bk:lis)
		{
			if(bk.getId()==id)
			{
				flag=1;
				bok=bk;
			}
		}

		return bok;
	}
	
	public Book AddBook(Book bk)
	{
		lis.add(bk);
		return bk;
	}
	
	public int DeleteBook(int id)
	{
		Book bok=null;
		int sn=0;
			for(Book bk:lis)
			{
				if(bk.getId()==id)
				{
					sn=lis.indexOf(bk);
				}
			}
			if(lis.get(sn)==null)
			{
				return 0;
			}
			else
			{
				lis.remove(sn);
				return 1;
			}
	}
			
			public Book UpdateBook(Book bok,int id)
			{
				int sn=0;
				for(Book bk:lis)
				{
					if(bk.getId()==id)
					{
						sn=lis.indexOf(bk);
					}
				}
				lis.remove(sn);
				lis.add(sn,bok);
				return bok;
			}
			

	
}
