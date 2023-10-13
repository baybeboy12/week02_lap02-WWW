package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public Optional<Product> findById(long id) {
        return productRepository.getProducteById(id);
    }

    public List<Product> getAllPro() {
        return productRepository.getAllProd();
    }
    public boolean insertPro(Product product){
        productRepository.insertProduct(product);
        return true;
    }
    public boolean updatePro(Product product){
        productRepository.updateProduct(product);
        return true;
    }
    public boolean deletePro(long id){
        productRepository.deleteProduct(id);
        return true;
    }
    public boolean activePro(long id){
        productRepository.activeProduct(id);
        return true;
    }
}
