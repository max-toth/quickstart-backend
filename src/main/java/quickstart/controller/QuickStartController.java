package quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quickstart.domain.QuickStartEntity;
import quickstart.service.QuickStartService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author mtolstyh
 * @since 24.01.2017.
 */

@RestController
@RequestMapping("/rest/api/0.1")
public class QuickStartController {

    @Autowired
    private QuickStartService quickStartService;

    @ResponseBody
    @RequestMapping(value = "{entity}", method = GET)
    public Page<QuickStartEntity> getList(@PathVariable("entity") String entity,
                                          @RequestParam("page") int page,
                                          @RequestParam("size") int size) {
        return quickStartService.get(entity, page, size);
    }

    @ResponseBody
    @RequestMapping(value = "{entity}/{id}", method = GET)
    public ResponseEntity get(@PathVariable("entity") String entity,
                              @PathVariable("id") String id) {
        return ResponseEntity.ok(quickStartService.get(entity, id));
    }

    @ResponseBody
    @RequestMapping(value = "{entity}", method = POST)
    public ResponseEntity<QuickStartEntity> post(@PathVariable("entity") String entity,
                                                    @RequestBody QuickStartEntity object) {
        return ResponseEntity.ok(quickStartService.save(entity, object));
    }

    @ResponseBody
    @RequestMapping(value = "{entity}/{id}", method = PUT)
    public ResponseEntity<QuickStartEntity> put(@PathVariable("entity") String entity,
                                                   @PathVariable("id") String id, //
                                                   @RequestBody QuickStartEntity object) {
        return ResponseEntity.ok(quickStartService.update(entity, object));
    }

    @ResponseBody
    @RequestMapping(value = "{entity}/{id}", method = DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("entity") String entity,
                                          @PathVariable("id") String id) {
        quickStartService.delete(entity, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
