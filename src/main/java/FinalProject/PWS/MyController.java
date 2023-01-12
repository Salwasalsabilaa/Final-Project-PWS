/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.PWS;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Inspiron
 */
@RestController
@CrossOrigin
public class MyController {
 PendudukJpaController control = new PendudukJpaController();
 
 @PostMapping("/POST")
 public String sendData(HttpEntity<String> kiriman) throws Exception{
  Penduduk datas = new Penduduk();
  String d = kiriman.getBody();
  ObjectMapper mapper = new ObjectMapper();
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  datas = mapper.readValue(d, Penduduk.class);
         control.create(datas);
  return d;
 }
 
 @PutMapping("/PUT")
 public String editData(HttpEntity<String> kiriman) throws Exception{
  Penduduk datas = new Penduduk();
  String d = kiriman.getBody();
  ObjectMapper mapper = new ObjectMapper();
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  datas = mapper.readValue(d, Penduduk.class);
         control.edit(datas);
  return d;
 }
 
 @DeleteMapping("/DELETE")
 public String deleteData(HttpEntity<String> kiriman) throws Exception{
  Penduduk datas = new Penduduk();
  String d = kiriman.getBody();
  ObjectMapper mapper = new ObjectMapper();
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  datas = mapper.readValue(d, Penduduk.class);
         control.destroy(datas.getId());
  return "id: "+datas.getId()+" deleted";
 }
 
 @GetMapping("/GET")
 public List<Penduduk> getTabel(){
  List<Penduduk> list = new ArrayList<>();
  try {
   list = control.findPendudukEntities();
  }
  catch (Exception e){}
  return list;
 }
}


