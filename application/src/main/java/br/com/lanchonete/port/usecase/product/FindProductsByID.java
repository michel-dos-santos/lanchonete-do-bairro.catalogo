package br.com.lanchonete.port.usecase.product;

import br.com.lanchonete.model.Product;

import java.util.UUID;

public interface FindProductsByID {

    Product findByID(UUID id);

}
