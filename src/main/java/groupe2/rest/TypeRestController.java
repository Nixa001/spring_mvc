package groupe2.rest;

import groupe2.entity.Type;
import groupe2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeRestController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public List<Type> getList() {
        return typeService.findAll();
    }

    @PostMapping
    public String save(@RequestBody Type type) {
        typeService.save(type);
        return "Type ajoute avec succes";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.delete(id);
        return "Type supprime avec succes";
    }

    @PutMapping("/edit/{id}")
    public Type edit(@PathVariable Long id, @RequestBody Type type) {
        Type typeBd = typeService.findById(id);
        typeBd.setLibelle(type.getLibelle());
        typeService.save(typeBd);

        return typeBd;
    }
}
