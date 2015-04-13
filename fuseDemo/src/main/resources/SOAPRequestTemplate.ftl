<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cus="http://customer.gov.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <cus:geraOrder>
         ${body}
      </cus:geraOrder>
   </soapenv:Body>
</soapenv:Envelope>