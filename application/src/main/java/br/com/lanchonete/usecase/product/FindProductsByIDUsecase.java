package br.com.lanchonete.usecase.product;

import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.model.Product;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.ProductRepository;
import br.com.lanchonete.port.usecase.product.FindProductsByID;

import java.util.UUID;

public class FindProductsByIDUsecase implements FindProductsByID {

    private final LogRepository logRepository;
    private final ProductRepository productRepository;

    public FindProductsByIDUsecase(ProductRepository productRepository, LogRepository logRepository) {
        this.logRepository = logRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product findByID(UUID id) {
        logRepository.info(FindProductsByIDUsecase.class, LogCode.LogCodeInfo._0019);
        Product product = productRepository.findById(id);
        logRepository.info(FindProductsByIDUsecase.class, LogCode.LogCodeInfo._0020);
        return product;
    }
}
