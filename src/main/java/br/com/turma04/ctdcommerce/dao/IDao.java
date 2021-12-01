package br.com.turma04.ctdcommerce.dao;

import java.util.List;

public interface IDao <T>{
     T salvar(T t);
     T buscar();

}
