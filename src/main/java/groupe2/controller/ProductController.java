package groupe2.controller;


import groupe2.entity.Product;
import groupe2.service.ProductService;
import groupe2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @GetMapping
    public String  getList(Model model){
        List<Product> list =  productService.findAll();
        model.addAttribute("products",list);
        return "product";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("types", typeService.findAll());
        return "form-product";
    }

    @PostMapping
    public String save(@ModelAttribute Product product, @RequestParam(required = false) String typeId){
        if (typeId != null && !typeId.isEmpty()) {
            product.setType(typeService.findById(Long.valueOf(typeId)));
        }
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("types", typeService.findAll());
        return "form-product";
    }


}
