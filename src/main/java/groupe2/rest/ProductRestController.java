package groupe2.rest;


import groupe2.entity.Product;
import groupe2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product>  getList(){
        List<Product> list =  productService.findAll();
        return list;
    }

    @PostMapping
    public String save(@RequestBody Product product){
        productService.save(product);
        return "Produit ajout avec succes";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "Produit supprime avec succes";
    }

    @PutMapping("/edit/{id}")
    public Product edit(@PathVariable Long id, @RequestBody Product product){
        Product productBd = productService.findById(id);
        productBd.setLibelle(product.getLibelle());
        productBd.setPrix(product.getPrix());
        productService.save(productBd);

        return productBd;
    }


}
