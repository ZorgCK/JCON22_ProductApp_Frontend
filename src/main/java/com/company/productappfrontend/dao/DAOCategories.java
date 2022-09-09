
package com.company.productappfrontend.dao;

import java.util.List;

import com.company.productappfrontend.domain.Category;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class DAOCategories
{
	public static List<Category> listCategories()
	{
		final Client client = ClientBuilder.newClient();
		
		final Response response = client
			.target("http://localhost:8086/categories/list")
			.request(MediaType.APPLICATION_JSON)
			.get(Response.class);
		response.bufferEntity();

		final List<Category> result = response.readEntity(new GenericType<List<Category>>()
		{});
		
		client.close();
		
		return result;
	}
}
