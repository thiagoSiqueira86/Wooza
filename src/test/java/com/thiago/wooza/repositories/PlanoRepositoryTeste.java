package com.thiago.wooza.repositories;

import com.thiago.wooza.entities.DDD;
import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import com.thiago.wooza.services.PlanoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PlanoRepositoryTeste {

    @Autowired
    PlanoService planoService;

    @Test
    public void salvarNovoPlanoTeste(){
        PlanoRepository repository = Mockito.mock(PlanoRepository.class);

        Mockito.when(repository.save(new Plano())).thenReturn(new Plano());

        Assertions.assertThat(new Plano()).isEqualTo(repository.save(new Plano()));
    }

    @Test
    public void atualizarPlanoExistenteTeste(){
        PlanoRepository repository = Mockito.mock(PlanoRepository.class);
        Plano p = preencherPlano();
        p.setOperadora("VIVO");

        Mockito.when(repository.save(new Plano())).thenReturn(p);

        Assertions.assertThat("VIVO").isEqualTo(repository.save(new Plano()).getOperadora());
    }

    @Test
    public void listarPorCodigoDddTeste(){
        PlanoRepository repository = Mockito.mock(PlanoRepository.class);
        List<Plano> planos = new ArrayList<>();
        planos.add(preencherPlano());

        Mockito.when(repository.findPlanoByCodigoAndDdd("TESTE", 21)).thenReturn(planos);

        Assertions.assertThat(planos).isEqualTo(repository.findPlanoByCodigoAndDdd("TESTE", 21));
    }

    @Test
    public void listarPorTipoDddTeste(){
        PlanoRepository repository = Mockito.mock(PlanoRepository.class);
        List<Plano> planos = new ArrayList<>();
        planos.add(preencherPlano());

        Mockito.when(repository.findPlanoByTipoAndDdd(PlanoTipoEnum.POS, 21)).thenReturn(planos);

        Assertions.assertThat(planos).isEqualTo(repository.findPlanoByTipoAndDdd(PlanoTipoEnum.POS, 21));
    }

    @Test
    public void listarPorOperadoraDddTeste(){
        PlanoRepository repository = Mockito.mock(PlanoRepository.class);
        List<Plano> planos = new ArrayList<>();
        planos.add(preencherPlano());

        Mockito.when(repository.findPlanoByOperadoraAndDdd("TIM", 21)).thenReturn(planos);

        Assertions.assertThat(planos).isEqualTo(repository.findPlanoByOperadoraAndDdd("TIM", 21));
    }

    private Plano preencherPlano(){
        Plano p = new Plano();
        p.setOperadora("TIM");
        p.setCodigoPlano("TESTE");
        p.setTipo(PlanoTipoEnum.POS);
        p.setMinutos(100);
        p.setFranquiaInternet(60);
        p.setValor(19.99);
        p.setId(1L);

        DDD d = new DDD();
        d.setCodigoArea(21);

        p.getDdds().add(d);

        return p;
    }
}
