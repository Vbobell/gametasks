/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    $('.opcaoMenu .botaoMenu').click(function(){
        var selecionado = $(this).attr('id');
        
        $('.cadastro,.fundo,.conteudo').slideUp();
        
            switch(selecionado){
            case 'adicionarUsuario':
                $('.fundo').slideDown();
                $('.cadastro:nth(0)').slideDown();
            break;
            case 'mostraUsuario':
                $('.conteudo:nth(0)').slideDown();
            break;
            case 'adicionarTarefa':
                $('.fundo').slideDown();
                $('.cadastro:nth(1)').slideDown();
            break;
            case 'mostraTarefa':
                $('.conteudo:nth(1)').slideDown();
            break;
             case 'mostraQuadro':
                $('.conteudo:nth(2)').slideDown();
            break;
            case 'mostraRanking':
                $('.conteudo:nth(3)').slideDown();
            break;
        }      
    });
    $('.cadastro').click(function(event){
        //event.preventDefault();
    });
    
    $('.fundo').click(function(){
        $(this).slideUp();
        $('.cadastro').slideUp();
    });

    altura = $(window).height();
    $('.menuLateral').css('height', altura);
    $('.ui.vertical.massive.menu').css('height', altura-80);
    
    $(window).resize(function () {
        altura = $(window).height();
        $('.menuLateral').css('height', altura);
        $('.ui.vertical.massive.menu').css('height', altura-80);
    });