package com.example.inventoryMaterial;

import com.example.inventoryMaterial.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 * @author Alejandro Mechiné
 * Clase utilizada para anadir dependencias.
 */

public class DependencyRepository {

    /* Declaración */
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        dependencyRepository = new DependencyRepository();
    }


    public DependencyRepository(){
        this.dependencies = new ArrayList<Dependency>();
        initialize();
    }

    private void initialize(){
        addDependency(new Dependency(1,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(3,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(4,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(5,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(6,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(7,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(8,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(9,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(10,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(11,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(12,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(13,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(14,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(15,"1º Ciclo Formativo Grado Superior","1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(16,"2º Ciclo Formativo Grado Superior","2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));

    }

    public static DependencyRepository getInstance(){
        if (dependencyRepository==null)
        {
            dependencyRepository=new DependencyRepository();
        }
        return dependencyRepository;
    }

    /**
     * Método que añade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency){
        dependencies.add(dependency);
    }
    public ArrayList<Dependency> getDependencies(){
        return dependencies;
    }
}
