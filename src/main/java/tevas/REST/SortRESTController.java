/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.REST;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tevas.dao.BaseDAO;
import tevas.dao.SuppliersDAO;
import tevas.objects.Base;
import tevas.objects.Suppliers;
import tevas.objects.Tikrinam;

/**
 *
 * @author manambar
 */
@RestController
@RequestMapping(value = "sort")
public class SortRESTController {

    @Autowired
    private SuppliersDAO suppliersDAO;
    @Autowired
    private BaseDAO baseDAO;
    List<Base> list = new ArrayList<>();
    List<Suppliers> supList = new ArrayList<>();

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/all")
    public List<Base> getAll() {
        list = baseDAO.findAll();
        supList = suppliersDAO.findAll();
        return list;
    }

    @PostMapping(produces = "application/json")
    @ResponseBody
    public List<Base> sortPanel(@RequestBody Tikrinam params) {
        System.out.println("paleidziam sorta");
        List<Base> list3 = new ArrayList<>();
        List<Base> list4 = new ArrayList<>();
        System.out.println(params);

        /*----------------atrenkam upes -------------------------*/
        if (!params.getRivers().equals("0")) {// atsirenkam upes, susikonstruojam lista su tinkamomis 
            for (int i = 0; i < list.size(); i++) {
                Base baseUnit = list.get(i);
                if (baseUnit.getWbcId().toString().contains(params.getRivers())) {
                    System.out.println(i + " iadinu");
                    list3.add(baseUnit);
                }
            }
        } else {
            list3 = list;
        }
        /*----------------jei reikia daugiau upiu -------------------------*/
        if (params.isMoreRivers()) {//jei reikia daugiau upiu
            for (int i = 0; i < list3.size(); i++) {
                Base baseUnit = list3.get(i);
                if (!baseUnit.getWbcId().isMonoRoute()) {//jei nera monoRoute
                    list4.add(list3.get(i));
                }
            }
            list3 = list4;
            list4 = new ArrayList<>();
        }

        /*----------------atrenkam visas nakvynes galimybes -------------------------*/
        if (params.isIsSleep()) {//jei reikia nakvynes
            if ((params.isBed()
                    && params.isForCampers()
                    && params.isPublicCamping()
                    && params.isPrivateCamping()
                    && params.isCostsMoney())//jei viskas pazymeta
                    || (!params.isBed()
                    && !params.isForCampers()
                    && !params.isPublicCamping()
                    && !params.isPrivateCamping()
                    && !params.isCostsMoney())) {//arba nepazymeta nieko
                //grazinti visus su nakvyne
                for (int i = 0; i < list3.size(); i++) {
                    Base baseUnit = list3.get(i);
                    if (baseUnit.getSleepingId().getIsSleep()) {//jei yra nakvyne
                        list4.add(list3.get(i));
                    }
                }
                list3 = list4;
                list4 = new ArrayList<>();

            } else {
                System.out.println("pazymeta kazkas konkreciai");
                if (params.isBed()) {//jei pazymeta kad nori namo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getBed()) {//jei yra namas
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isForCampers()) {//jei pazymeta kad nori kemperi pasistatyti
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getForCampers()) {//jei yra camperems vieta
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isPublicCamping()) {//jei pazymeta kad valstybinio kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getPublicCamping()) {//jei yra kempingas
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isPrivateCamping()) {//jei pazymeta kad nori privataus kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getPrivateCamping()) {//jei yra privatus kempingas
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isCostsMoney() && !params.isIsFree()) {//jei pazymeta kad nori mokamo kempingo ir nepazymeta, kad nori nemokamo kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getCostsMoney()) {//jei yra mokamas kempingas
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isIsFree() && !params.isCostsMoney()) {//jei pazymeta kad nori nemokamo kempingo ir nepazymeta, kad nori mokamo kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (!baseUnit.getSleepingId().getCostsMoney()) {//jei yra nemokamas kempingas
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

            }
        }

        //shop
        if (params.isIsShop()) {//jei pazymeta kad nori nemokamo kempingo ir nepazymeta, kad nori mokamo kempingo
            if ((params.isShop1()
                    && params.isShop2()
                    && params.isShop3())
                    || (!params.isShop1()
                    && !params.isShop2()
                    && !params.isShop3())) {

                for (int i = 0; i < list3.size(); i++) {
                    Base baseUnit = list3.get(i);
                    if (baseUnit.getShopId().getIsShop()) {//jei isvis yra parduotuve 
                        list4.add(list3.get(i));
                    }
                }
                list3 = list4;
                list4 = new ArrayList<>();
            } else {

                if (params.isShop1()) {//jei pazymeta kad nori parduotuves pradzioje
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getShopId().getShopBefore()) {//jei yra parduotuve pradzioje System.out.println("-"+i+"+");
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                if (params.isShop2()) {//jei pazymeta kad nori parduotuves vidury
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getShopId().getShopOnRoad()) {//jei yra parduotuve vidury
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                if (params.isShop3()) {//jei pazymeta kad nori parduotuves gale
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getShopId().getShopAfter()) {//jei yra parduotuve gale
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
            }
        }

        if (params.isIsParking()) {
            System.out.println("reikia parkingo");
            if ((params.isParkingSecured()
                    && params.isParkingNotSecured()
                    && params.isParkingStart()
                    && params.isParkingMiddle()
                    && params.isParkingEnd())
                    || (!params.isParkingSecured()
                    && !params.isParkingNotSecured()
                    && !params.isParkingStart()
                    && !params.isParkingMiddle()
                    && !params.isParkingEnd())) {
                System.out.println("pazymeta viskas arba nieko. list size " + list3.size());
                for (int i = 0; i < list3.size(); i++) {
                    Base baseUnit = list3.get(i);
                    System.out.println(i + " " + baseUnit.getParkingId().getIsParking());
                    if (baseUnit.getParkingId().getIsParking()) {//jei isvis yra parkingas 
                        System.out.println("addinam");
                        list4.add(list3.get(i));
                    }
                }
                list3 = list4;
                list4 = new ArrayList<>();
            } else {//jei reikia saugaus, nesaugus nepazymeta
                if (params.isParkingSecured() && !params.isParkingNotSecured()) {
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getParkingId().getSafety()) {//grazinam saugius
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }//jei NEreikia saugaus, nesaugus PAzymeta
                if (!params.isParkingSecured() && params.isParkingNotSecured()) {
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (!baseUnit.getParkingId().getSafety()) {//grazinam nesaugius
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isParkingStart()) {
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getParkingId().getParkingAtStart()) {//grazinam nesaugius
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                if (params.isParkingMiddle()) {
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getParkingId().getParkingAtMid()) {//grazinam nesaugius
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                if (params.isParkingEnd()) {
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getParkingId().getParkingAtEnd()) {//grazinam nesaugius
                            list4.add(list3.get(i));
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
            }

        }
        return list3;
    }
}
