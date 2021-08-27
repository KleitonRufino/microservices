package com.example.pedido.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.pedido.entity.Client;

@FeignClient(name="cadastro")
public interface ClientProxy {

	@GetMapping(value = "/cadastro/client/find/{id}")
	public Client findById(@PathVariable("id") Long id, @RequestHeader("Authorization") String authorization);
}
