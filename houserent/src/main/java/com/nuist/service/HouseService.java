package com.nuist.service;

import com.nuist.domain.House;

public class HouseService {
    private House[] houses;
    private int count = 0;
    private int id = 1;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House house) {
        if (count == houses.length){
            System.out.println("满了!!!");
            return false;
        }
        house.setId(id++);
        houses[count++] = house;
        System.out.println("添加成功!!!");
        return true;
    }

    public boolean delete(int deleteid) {
        for (int i=0;i<count;i++)
            if (houses[i].getId() == deleteid) {
                for (int j = i; j < count - 1; j++) {
                    houses[j] = houses[j + 1];
                }
                houses[--count] = null;
                return true;
            }
        return false;
    }

    public House find(int id) {
        for (House house:houses) {
            if (house!=null)
                if (house.getId() == id)
                    return house;
        }
        return null;
    }
}
