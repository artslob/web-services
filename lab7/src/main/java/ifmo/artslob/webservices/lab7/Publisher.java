package ifmo.artslob.webservices.lab7;

import org.uddi.api_v3.*;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;

class Publisher {
    private static UDDIClerk clerk = null;

    Publisher() {
        try {
            clerk = new UDDIClient("META-INF/uddi.xml").getClerk("default");
            if (clerk == null)
                throw new Exception("the clerk wasn't found, check the config file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void publish(
            String businessName,
            String serviceName,
            String wsdlAddress
    ) {
        try {
            BusinessEntity myBusEntity = new BusinessEntity();
            Name myBusName = new Name();
            myBusName.setValue(businessName);
            myBusEntity.getName().add(myBusName);

            BusinessEntity register = clerk.register(myBusEntity);
            if (register == null) {
                System.out.println("Save failed!");
                System.exit(1);
            }
            String myBusKey = register.getBusinessKey();
            System.out.println(String.format("Key of business '%s' is '%s'.", businessName, myBusKey));

            BusinessService myService = new BusinessService();
            myService.setBusinessKey(myBusKey);
            Name myServiceName = new Name();
            myServiceName.setValue(serviceName);
            myService.getName().add(myServiceName);

            BindingTemplate myBindingTemplate = new BindingTemplate();
            AccessPoint accessPoint = new AccessPoint();
            accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
//            accessPoint.setValue("http://example.org/services/myservice?wsdl");
            accessPoint.setValue(wsdlAddress);
            myBindingTemplate.setAccessPoint(accessPoint);
            BindingTemplates myBindingTemplates = new BindingTemplates();

            myBindingTemplates.getBindingTemplate().add(UDDIClient.addSOAPtModels(myBindingTemplate));
            myService.setBindingTemplates(myBindingTemplates);

            BusinessService svc = clerk.register(myService);
            if (svc == null) {
                System.out.println("Save failed!");
                System.exit(1);
            }
            System.out.println(String.format("Key of service '%s' is '%s'.", serviceName, svc.getServiceKey()));

            clerk.discardAuthToken();
            System.out.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
