/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('.cadastro').removeClass('displayBlock');
    
    $('.botaoMenu').click(function(){
        var selecionado = $(this).attr('id');
            switch(selecionado){
            case 'adicionar':
                $('.cadastro').addClass('displayBlock');
            break;
        }      
    });
    $('.fundo').click(function(){
         $('.cadastro').removeClass('displayBlock');
    });
 });

