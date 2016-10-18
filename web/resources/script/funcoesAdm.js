/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    $('.opcaoMenu .botaoMenu').click(function(){
        var selecionado = $(this).attr('id');
            switch(selecionado){
            case 'adicionarUsuario':
                $('.cadastro:nth(0),.fundo').toggleClass('displayBlock');
            break;
            case 'mostraUsuario':
                $('.conteudo:nth(0)').toggleClass('displayBlock');
            break;
            case 'adicionarTarefa':
                $('.cadastro:nth(1),.fundo').toggleClass('displayBlock');
            break;
            case 'mostraTarefa':
                $('.conteudo:nth(1)').toggleClass('displayBlock');
            break;
        }      
    });
    $('.cadastro').click(function(event){
        event.preventDefault();
    });

    
    


