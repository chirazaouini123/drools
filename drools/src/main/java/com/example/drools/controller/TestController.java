package com.example.drools.controller;

import com.example.drools.model.Address;
import com.example.drools.model.fact.AddressCheckResult;
import com.example.drools.service.ReloadDroolsRulesService;
import org.drools.core.common.InternalAgenda;
import org.kie.api.runtime.KieSession;;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private ReloadDroolsRulesService rules;



@ResponseBody
    //@PostMapping("/address/{num}")
@RequestMapping("/address")
    public void test( ){
        Address address = new Address();
        address.setPostcode("99999");
        address.setStreet("test");
        reload();
        KieSession kieSession = ReloadDroolsRulesService.kieContainer.newKieSession();
      //KieSession kieSession = kieContainer.newKieSession();

        AddressCheckResult result = new AddressCheckResult();

        kieSession.insert(address);
        kieSession.insert(result);
    //((InternalAgenda)kieSession.getAgenda()).activateRuleFlowGroup("group1");
    //(kieSession.getAgenda()).getAgendaGroup("groupB").setFocus();


    int ruleFiredCount = kieSession.fireAllRules();
        kieSession.destroy();
       // System.out.println( ruleFiredCount + " regle declenche");
        if(result.isPostCodeResult()){
            System.out.println("Vérification des règles réussie");
        }
        System.out.println( ruleFiredCount + " regle declenche");

    }


    @ResponseBody
    @RequestMapping("/reload")
    public String reload()  {
        rules.reload();
        return "ok";
    }


    /**
     * 生成随机数
     * @param num
     * @return
     */
    public String generateRandom(int num) {
        String chars = "0123456789";
        StringBuffer number=new StringBuffer();
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            number=number.append(chars.charAt(rand));
        }
        return number.toString();
    }
}
