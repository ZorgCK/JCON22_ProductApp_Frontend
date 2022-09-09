
package com.company.productappfrontend.dao;

import java.util.List;

import com.company.productappfrontend.domain.Product;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class DAOProducts
{
	public static List<Product> listProducts()
	{
		final Client client = ClientBuilder.newClient();

		final Response response = client
			.target("http://localhost:8086/products/list")
			.request(MediaType.APPLICATION_JSON)
			.get(Response.class);
		
		response.bufferEntity();
		
		final List<Product> result = response.readEntity(new GenericType<List<Product>>()
		{});

		client.close();
		
		return result;
	}

	public static Product updateProduct(final Product product)
	{
		final Client client = ClientBuilder.newClient();

		final Response response =
			client.target("http://localhost:8086/products/update")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(product, MediaType.APPLICATION_JSON));

		final Product result = response.readEntity(Product.class);

		client.close();

		return result;
	}

	public static Product insertProduct(final Product product)
	{
		final Client client = ClientBuilder.newClient();

		final Response response =
			client.target("http://localhost:8086/products/insert")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(product, MediaType.APPLICATION_JSON));

		final Product result = response.readEntity(Product.class);
		
		client.close();
		
		return result;
	}

	public static void deleteProduct(final Product product)
	{
		final Client client = ClientBuilder.newClient();

		final Response response = client.target("http://localhost:8086/products/delete")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(product, MediaType.APPLICATION_JSON));

		client.close();
	}
}
