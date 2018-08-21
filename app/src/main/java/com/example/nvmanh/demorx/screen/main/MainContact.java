package com.example.nvmanh.demorx.screen.main;

import com.example.nvmanh.demorx.data.model.Hero;

import java.util.List;

public interface MainContact {
    interface View {
        void showHeros(List<Hero> heroes);
        void showErros();
    }

    interface Presenter {
        void getHeros();
        void searchHero(String key);
    }
}
