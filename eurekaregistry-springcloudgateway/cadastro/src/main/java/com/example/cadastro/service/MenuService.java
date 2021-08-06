package com.example.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cadastro.dto.MenuDto;
import com.example.cadastro.dto.MenuOrderDto;
import com.example.cadastro.entity.Menu;
import com.example.cadastro.entity.Restaurant;
import com.example.cadastro.exception.NotFoundException;
import com.example.cadastro.message.MenuSendMessage;
import com.example.cadastro.repository.MenuRepository;
import com.example.cadastro.repository.RestaurantRepository;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuSendMessage menuSendMessage;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository, MenuSendMessage menuSendMessage) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuSendMessage = menuSendMessage;
    }

    public Menu saveMenu(MenuDto menuDto) throws NotFoundException {

        System.out.println(menuDto);

        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDto.getIdRestaurant());

        if (restaurant.isPresent()) {
            Menu menu = Menu.create(menuDto);
            menu.setRestaurant(restaurant.get());
            Menu newMenu = menuRepository.save(menu);
            menuSendMessage.sendMessage(MenuOrderDto.create(newMenu));
            return newMenu;
        }

        throw new NotFoundException("Restaurante não encontrado");

    }

    public Menu updateMenu(Menu menu) {

        final Optional<Menu> optional = menuRepository.findById(menu.getId());

        if (optional.isPresent()) {
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    @Cacheable("teste")
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

}
