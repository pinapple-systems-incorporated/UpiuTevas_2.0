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
        List<Base> list3 = new ArrayList<>();
        List<Base> list4 = new ArrayList<>();
      System.out.println(params);
        if (!params.getRivers().equals("0")) {// atsirenkam upes, susikonstruojam lista su tinkamomis 
         
            for (int i = 0; i < list.size(); i++) {
                Base baseUnit = list.get(i);
                if (baseUnit.getWbcId().toString().contains(params.getRivers())) {
                    System.out.println(i+ " iadinu");
                    list3.add(baseUnit);
                }
            }
        } else {
            list3 = list;
        }
     
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
          String repetance = "";
        if (params.isIsSleep()) {//jei reikia nakvynes
            System.out.println("noriu nakvynes salyga patenkinta");
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
                System.out.println("niekas nepazymeta arba pazymeta viskas");
                //grazinti visus su nakvyne
                for (int i = 0; i < list3.size(); i++) {
                    Base baseUnit = list3.get(i);
                    if (baseUnit.getSleepingId().getIsSleep()) {//jei yra nakvyne
                        repetance+=","+list3.get(i).getId();
                        list4.add(list3.get(i));
                        System.out.println("list3.get("+i+"),base id "+list3.get(i).getId()+" isSleep");
                    }
                }
                list3 = list4;
                list4 = new ArrayList<>();

            } else {
                if (params.isBed()) {//jei pazymeta kad nori namo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getBed()) {//jei yra namas
                            if (!repetance.contains(list3.get(i).getId()+"")) {
                                
                            
                            list4.add(list3.get(i));
                            }
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isForCampers()) {//jei pazymeta kad nori kemperi pasistatyti
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getForCampers()) {//jei yra camperems vieta
                            
                            if (!repetance.contains(list3.get(i).getId()+"")) {
                                list4.add(list3.get(i));
                            }
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isPublicCamping()) {//jei pazymeta kad valstybinio kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getPublicCamping()) {//jei yra kempingas
                          if (!repetance.contains(list3.get(i).getId()+"")) {
                              list4.add(list3.get(i));
                          }
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }

                if (params.isPrivateCamping()) {//jei pazymeta kad nori privataus kempingo
                    if ((params.isCostsMoney() //ir pazymeta, kad nori mokamo ir nemokamo
                            && params.isIsFree())
                            || (!params.isCostsMoney()//arba nepazymeta mokamas ar nemokamas
                            && !params.isIsFree())) {
                        //do nothing
                    }
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getPrivateCamping()) {//jei yra privatus kempingas
                           
                            if (!repetance.contains(list3.get(i).getId()+"")) {
                                list4.add(list3.get(i));
                            }
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                
                  if (params.isCostsMoney()&&!params.isIsFree()) {//jei pazymeta kad nori mokamo kempingo ir nepazymeta, kad nori nemokamo kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (baseUnit.getSleepingId().getCostsMoney()) {//jei yra mokamas kempingas
                           if (!repetance.contains(list3.get(i).getId()+"")) {
                               list4.add(list3.get(i));
                           }
                        }
                    }
                    list3 = list4;
                    list4 = new ArrayList<>();
                }
                  
                   if (params.isIsFree()&&!params.isCostsMoney()) {//jei pazymeta kad nori nemokamo kempingo ir nepazymeta, kad nori mokamo kempingo
                    for (int i = 0; i < list3.size(); i++) {
                        Base baseUnit = list3.get(i);
                        if (!baseUnit.getSleepingId().getCostsMoney()) {//jei yra nemokamas kempingas
                          if (!repetance.contains(list3.get(i).getId()+"")) {
                                list4.add(list3.get(i));
                          }
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
