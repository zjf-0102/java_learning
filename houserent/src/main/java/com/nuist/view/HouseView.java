package com.nuist.view;

import com.nuist.domain.House;
import com.nuist.service.HouseService;
import com.nuist.utils.Utility;

public class HouseView {

    private boolean show = true;
    private char key;
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        while (show) {
            System.out.println("==========房屋出租系统==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房源");
            System.out.println("\t\t\t4 修改信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出系统");
            System.out.print("选择功能：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    add();
                    break;
                case '2':
                    find();
                    break;
                case '3':
                    delete();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    list();
                    break;
                case '6':
                    show = false;
                    break;
            }
        }
    }

    public void list() {
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house != null)
                System.out.println(house);
        }
    }

    public void add() {
        System.out.println("----------添加房屋----------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House(name, phone, address, rent, state);
        houseService.add(house);
    }

    public void delete() {
        System.out.println("----------删除房屋----------");
        System.out.print("输入要删除的房屋编号：");
        int deleteid = Utility.readInt();
        if (deleteid == -1)
            return;
        if ('Y' == Utility.readConfirmSelection())
            if (houseService.delete(deleteid))
                System.out.println("删除成功!!!");
            else
                System.out.println("房屋不存在!!!");
    }

    public void find() {
        System.out.println("----------查找房屋----------");
        System.out.print("输入要查的id：");
        int id = Utility.readInt();
        House house = houseService.find(id);
        if (house != null)
            System.out.println(house);
        else
            System.out.println("不存在!!!");
    }

    public void update() {
        System.out.println("----------更新信息----------");
        System.out.print("输入要改的id：");
        int updateid = Utility.readInt();
        if (updateid == -1)
            return;
        House house = houseService.find(updateid);
        if (house == null) {
            System.out.println("不存在!!!");
            return;
        }
        System.out.print("姓名(" + house.getName() + ")：");
        String name = Utility.readString(8,"");
        if (!"".equals(name))
            house.setName(name);

        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = Utility.readString(12,"");
        if (!"".equals(phone))
            house.setPhone(phone);

        System.out.print("地址(" + house.getAddress() + ")：");
        String address = Utility.readString(18,"");
        if (!"".equals(address))
            house.setAddress(address);

        System.out.print("租金(" + house.getRent() + ")：");
        int rent = Utility.readInt(-1);
        if (rent != -1)
            house.setRent(rent);

        System.out.print("状态(" + house.getState() + ")：");
        String state = Utility.readString(3,"");
        if (!"".equals(state))
            house.setState(state);

        System.out.println("修改成功!!!");
    }
}
