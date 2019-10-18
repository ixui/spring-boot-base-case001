package jp.co.ixui.example.base.case001.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ixui.example.base.case001.controller.dto.ItemDto;
import jp.co.ixui.example.base.case001.domain.Item;
import jp.co.ixui.example.base.case001.exception.Http404NotFoundException;
import jp.co.ixui.example.base.case001.service.ItemService;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

	@Autowired
	ItemService service;

	@GetMapping("")
    public List<ItemDto> get() {
		return service.fetchAll().stream()
				.map(item -> {
					return new ItemDto(item);
				})
				.collect(Collectors.toList());
    }
	
	@GetMapping("{id:[0-9]+$}")
    public ItemDto get(@PathVariable Long id) {
        return new ItemDto(
        		Optional.ofNullable(service.fetchById(id))
        			.orElseThrow(() -> new Http404NotFoundException()));
    }

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
    public void create(@ModelAttribute ItemDto item) {
		Item model = new Item();
		model.setName(item.getName());
		service.create(model);
    }

	@PutMapping("{id:[0-9]+$}")
	@ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @ModelAttribute ItemDto item) {
		Item model = new Item();
		model.setId(id);
		model.setName(item.getName());
		service.update(model);
    }

	@DeleteMapping("{id:[0-9]+$}")
	@ResponseStatus(HttpStatus.OK)
    public void destroy(@PathVariable Long id) {
		service.destroy(id);
    }

}
