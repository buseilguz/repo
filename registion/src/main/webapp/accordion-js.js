$(document).ready(function() {
	function close_accordion_section() { //akordiyon bölümlerini kapat
		$('.accordion .accordion-section-title').removeClass('active'); //active class sil
		$('.accordion .accordion-section-content').slideUp(300).removeClass('open'); //sayfayi yukari dogru kapa yavasca kapat, open class sil
	}
	$('.accordion-section-title').click(function(e) {
		if($(e.target).is('.active')) { //tiklanilan akordiyon sayfasi acik ise
			close_accordion_section(); //kapat sayfayi
		}else {
			close_accordion_section(); //kapat sayfayi
			$(this).addClass('active'); //tiklanilan akordiyonu aktif et
			$(this).next().slideDown(300).addClass('open'); //tiklanan akordiyon icerigini asagi dogru yavasca ac ve open class ata
		}
		e.preventDefault(); //a href sayfa yonlendirme yapma
	});
});