package utils;

import java.util.Iterator;
import java.util.List;

import beans.ArticolDB;

public class UtilsArticole {

	public static void getArt111Only(List<ArticolDB> listArticole) {

		Iterator<ArticolDB> artIterator = listArticole.iterator();

		while (artIterator.hasNext()) {
			if (!artIterator.next().getCod().startsWith("111"))
				artIterator.remove();
		}

	}
	
	
	public static boolean isArticolPermitSubCmp(String codArticol) {

		String articoleExceptie = "000000000010300576" + "000000000010300578" + "000000000010300582" + "000000000010300595" + "000000000010300598"
				+ "000000000010300612" + "000000000010300613" + "000000000010300616" + "000000000010300619" + "000000000010300625" + "000000000010300689"
				+ "000000000010300694" + "000000000010300702" + "000000000010300721" + "000000000010300800" + "000000000010301533" + "000000000010301860"
				+ "000000000010303170" + "000000000010303179" + "000000000010303817" + "000000000010304377" + "000000000010304620" + "000000000010306572"
				+ "000000000010306690" + "000000000010306691" + "000000000010308976" + "000000000010300742" + "000000000010300743" + "000000000010300744"
				+ "000000000010300747" + "000000000010300751" + "000000000010309031" + "000000000010307423" + "000000000010307568" + "000000000010302285"
				+ "000000000010302296" + "000000000010302314" + "000000000010300531" + "000000000010300532" + "000000000010304160" + "000000000010300640"
				+ "000000000010300657" + "000000000010300658" + "000000000010300660" + "000000000010300664" + "000000000010300665" + "000000000010300668"
				+ "000000000010300673" + "000000000010303742" + "000000000010303743" + "000000000010303756" + "000000000010301993" + "000000000010302012"
				+ "000000000010302014" + "000000000010302054" + "000000000010302055" + "000000000010307324" + "000000000010304724" + "000000000010302960"
				+ "000000000010302963" + "000000000010305096" + "000000000010304562" + "000000000030100792" + "000000000010305225" + "000000000010303019"
				+ "000000000010300776" + "000000000010300789" + "000000000010300794" + "000000000010303851" + "000000000010302364" + "000000000010302366"
				+ "000000000010302369" + "000000000010302373" + "000000000010302834" + "000000000010307794" + "000000000010309312" + "000000000010309314"
				+ "000000000010309807" + "000000000010309943" + "000000000010300577" + "000000000010300587" + "000000000010300589" + "000000000010300593"
				+ "000000000010300599" + "000000000010300600" + "000000000010300606" + "000000000010300622" + "000000000010300688" + "000000000010300690"
				+ "000000000010300703" + "000000000010300714" + "000000000010300723" + "000000000010300729" + "000000000010300734" + "000000000010300735"
				+ "000000000010300736" + "000000000010300802" + "000000000010300804" + "000000000010301807" + "000000000010302470" + "000000000010302472"
				+ "000000000010303018" + "000000000010303174" + "000000000010303177" + "000000000010303295" + "000000000010304230" + "000000000010304334"
				+ "000000000010304337" + "000000000010306178" + "000000000010308974" + "000000000010300755" + "000000000010300761" + "000000000010300768"
				+ "000000000010305524" + "000000000010309017" + "000000000010308697" + "000000000010303367" + "000000000010303368" + "000000000010302280"
				+ "000000000010302284" + "000000000010302286" + "000000000010302291" + "000000000010302298" + "000000000010302311" + "000000000010303222"
				+ "000000000010303224" + "000000000010303225" + "000000000010300533" + "000000000010300542" + "000000000010300547" + "000000000010300549"
				+ "000000000010300550" + "000000000010300562" + "000000000010300566" + "000000000010300570" + "000000000010301650" + "000000000010303880"
				+ "000000000010300636" + "000000000010300643" + "000000000010300677" + "000000000010300678" + "000000000010303744" + "000000000010301991"
				+ "000000000010301992" + "000000000010302051" + "000000000010306771" + "000000000010307325" + "000000000010302961" + "000000000010305232"
				+ "000000000010306180" + "000000000010303033" + "000000000010301941" + "000000000010301949" + "000000000010300787" + "000000000010300788"
				+ "000000000010303855" + "000000000010303869" + "000000000010302368" + "000000000010307792" + "000000000010309313" + "000000000010309806"
				+ "000000000010309952" + "000000000010310422" + "000000000010300604" + "000000000010300607" + "000000000010300611" + "000000000010300626"
				+ "000000000010300693" + "000000000010300697" + "000000000010300698" + "000000000010300722" + "000000000010300726" + "000000000010300731"
				+ "000000000010302339" + "000000000010302647" + "000000000010303173" + "000000000010303175" + "000000000010303178" + "000000000010303184"
				+ "000000000010303185" + "000000000010303816" + "000000000010304374" + "000000000010306573" + "000000000010306695" + "000000000010306952"
				+ "000000000010300741" + "000000000010300745" + "000000000010300763" + "000000000010300764" + "000000000010300769" + "000000000010302244"
				+ "000000000010302293" + "000000000010302310" + "000000000010302312" + "000000000010302580" + "000000000010300534" + "000000000010300539"
				+ "000000000010300541" + "000000000010300553" + "000000000010300554" + "000000000010300557" + "000000000010300564" + "000000000010300567"
				+ "000000000010300568" + "000000000010301708" + "000000000010303886" + "000000000010300642" + "000000000010300659" + "000000000010300666"
				+ "000000000010300679" + "000000000010302010" + "000000000010302013" + "000000000010302050" + "000000000010307323" + "000000000010304567"
				+ "000000000010306407" + "000000000010301913" + "000000000010300771" + "000000000010300782" + "000000000010300786" + "000000000010300791"
				+ "000000000010300792" + "000000000010303857" + "000000000010303859" + "000000000010302362" + "000000000010302365" + "000000000010309808"
				+ "000000000010307402" + "000000000010300575" + "000000000010300581" + "000000000010300583" + "000000000010300584" + "000000000010300591"
				+ "000000000010300592" + "000000000010300608" + "000000000010300695" + "000000000010300696" + "000000000010300700" + "000000000010300705"
				+ "000000000010300724" + "000000000010300739" + "000000000010301805" + "000000000010301830" + "000000000010301840" + "000000000010303180"
				+ "000000000010303186" + "000000000010303820" + "000000000010304235" + "000000000010304333" + "000000000010304528" + "000000000010306570"
				+ "000000000010306571" + "000000000010306596" + "000000000010306599" + "000000000010306692" + "000000000010306694" + "000000000010300748"
				+ "000000000010300750" + "000000000010300758" + "000000000010309016" + "000000000010303369" + "000000000010302281" + "000000000010302299"
				+ "000000000010302581" + "000000000010303221" + "000000000010303227" + "000000000010300560" + "000000000010300565" + "000000000010300572"
				+ "000000000010303884" + "000000000010303889" + "000000000010304165" + "000000000010300634" + "000000000010300647" + "000000000010300662"
				+ "000000000010300672" + "000000000010300675" + "000000000010302011" + "000000000010302046" + "000000000010302052" + "000000000010302057"
				+ "000000000010302058" + "000000000010302911" + "000000000010302966" + "000000000010304566" + "000000000010306902" + "000000000010305226"
				+ "000000000010309813" + "000000000010306181" + "000000000010301925" + "000000000010300781" + "000000000010300795" + "000000000010300798"
				+ "000000000010305458" + "000000000010302372" + "000000000010300586" + "000000000010300590" + "000000000010300617" + "000000000010300621"
				+ "000000000010300624" + "000000000010300692" + "000000000010300699" + "000000000010300717" + "000000000010300725" + "000000000010300728"
				+ "000000000010300738" + "000000000010300799" + "000000000010300807" + "000000000010300808" + "000000000010301861" + "000000000010302473"
				+ "000000000010302518" + "000000000010303176" + "000000000010303183" + "000000000010304234" + "000000000010304331" + "000000000010304375"
				+ "000000000010304529" + "000000000010306177" + "000000000010306693" + "000000000010307348" + "000000000010308975" + "000000000010300746"
				+ "000000000010300749" + "000000000010300759" + "000000000010300760" + "000000000010300767" + "000000000010305525" + "000000000010308701"
				+ "000000000010307602" + "000000000010302262" + "000000000010302264" + "000000000010302283" + "000000000010302290" + "000000000010302294"
				+ "000000000010302313" + "000000000010302582" + "000000000010303220" + "000000000010303226" + "000000000010303228" + "000000000010300540"
				+ "000000000010300555" + "000000000010300563" + "000000000010300571" + "000000000010300573" + "000000000010303891" + "000000000010300638"
				+ "000000000010300639" + "000000000010300641" + "000000000010300644" + "000000000010300663" + "000000000010300670" + "000000000010300680"
				+ "000000000010300681" + "000000000010304695" + "000000000010304725" + "000000000010302965" + "000000000010302967" + "000000000010302968"
				+ "000000000010305097" + "000000000010304563" + "000000000010305229" + "000000000010309812" + "000000000010301926" + "000000000010301951"
				+ "000000000010300772" + "000000000010300777" + "000000000010300779" + "000000000010300784" + "000000000010300790" + "000000000010300793"
				+ "000000000010303868" + "000000000010302363" + "000000000010302370" + "000000000010302820" + "000000000010309801" + "000000000010309803"
				+ "000000000010309805" + "000000000010307403" + "000000000010310098" + "000000000010300585" + "000000000010300596" + "000000000010300601"
				+ "000000000010300602" + "000000000010300609" + "000000000010300618" + "000000000010300629" + "000000000010300691" + "000000000010300708"
				+ "000000000010300709" + "000000000010300715" + "000000000010300718" + "000000000010300805" + "000000000010301534" + "000000000010301806"
				+ "000000000010303171" + "000000000010303172" + "000000000010303181" + "000000000010303182" + "000000000010303187" + "000000000010303188"
				+ "000000000010303818" + "000000000010304338" + "000000000010304339" + "000000000010304376" + "000000000010306574" + "000000000010306597"
				+ "000000000030100191" + "000000000010300752" + "000000000010307417" + "000000000010307601" + "000000000010302243" + "000000000010302263"
				+ "000000000010302292" + "000000000010302295" + "000000000010300545" + "000000000010300552" + "000000000010303882" + "000000000010303888"
				+ "000000000010304166" + "000000000010304167" + "000000000010300669" + "000000000010300676" + "000000000010300682" + "000000000010300308"
				+ "000000000010303741" + "000000000010303777" + "000000000010301994" + "000000000010302015" + "000000000010302053" + "000000000010302056"
				+ "000000000010306099" + "000000000010302910" + "000000000010302962" + "000000000010309162" + "000000000010304569" + "000000000010305218"
				+ "000000000010305219" + "000000000010309811" + "000000000010301915" + "000000000010301931" + "000000000010301950" + "000000000010300770"
				+ "000000000010300773" + "000000000010300778" + "000000000010300783" + "000000000010300796" + "000000000010300797" + "000000000010303856"
				+ "000000000010303858" + "000000000010306775" + "000000000010305463" + "000000000010302367" + "000000000010302371" + "000000000010307525"
				+ "000000000010305123" + "000000000010307806" + "000000000010309809" + "000000000010310024" + "000000000010310154" + "000000000010310573"
				+ "000000000010300588" + "000000000010300594" + "000000000010300605" + "000000000010300610" + "000000000010300620" + "000000000010300623"
				+ "000000000010300628" + "000000000010300706" + "000000000010300707" + "000000000010300712" + "000000000010300720" + "000000000010300730"
				+ "000000000010300737" + "000000000010300806" + "000000000010302474" + "000000000010302519" + "000000000010303142" + "000000000010304332"
				+ "000000000010304336" + "000000000010306680" + "000000000010300740" + "000000000010300754" + "000000000010300756" + "000000000010300766"
				+ "000000000010307600" + "000000000010302242" + "000000000010302245" + "000000000010302282" + "000000000010302297" + "000000000010303223"
				+ "000000000010300544" + "000000000010300551" + "000000000010300556" + "000000000010300558" + "000000000010300559" + "000000000010300561"
				+ "000000000010303881" + "000000000010303883" + "000000000010300630" + "000000000010300631" + "000000000010300633" + "000000000010300635"
				+ "000000000010300646" + "000000000010300649" + "000000000010300656" + "000000000010300661" + "000000000010300667" + "000000000010300671"
				+ "000000000010300674" + "000000000010300311" + "000000000010302048" + "000000000010307313" + "000000000010302964" + "000000000010305228"
				+ "000000000010309810" + "000000000010306182" + "000000000010300774" + "000000000010300785" + "000000000010305457" + "000000000010306877"
				+ "000000000010304677" + "000000000010304239" + "000000000010302832" + "000000000010307070" + "000000000010309315" + "000000000010309316"
				+ "000000000010309804" + "000000000010310011" + "000000000010300579" + "000000000010300580" + "000000000010300597" + "000000000010300603"
				+ "000000000010300614" + "000000000010300615" + "000000000010300627" + "000000000010300687" + "000000000010300701" + "000000000010300704"
				+ "000000000010300710" + "000000000010300711" + "000000000010300713" + "000000000010300716" + "000000000010300719" + "000000000010300727"
				+ "000000000010300732" + "000000000010300733" + "000000000010300801" + "000000000010300803" + "000000000010301542" + "000000000010301853"
				+ "000000000010301872" + "000000000010302101" + "000000000010302471" + "000000000010304236" + "000000000010304335" + "000000000010300753"
				+ "000000000010300757" + "000000000010300762" + "000000000010300765" + "000000000010309018" + "000000000010308700" + "000000000010302241"
				+ "000000000010300535" + "000000000010300536" + "000000000010300537" + "000000000010300538" + "000000000010300543" + "000000000010300548"
				+ "000000000010300569" + "000000000010300574" + "000000000010303887" + "000000000010300632" + "000000000010300637" + "000000000010300645"
				+ "000000000010300648" + "000000000010300309" + "000000000010300310" + "000000000010302047" + "000000000010302049" + "000000000010304712"
				+ "000000000010304723" + "000000000010302880" + "000000000010304568" + "000000000010305223" + "000000000010305224" + "000000000010305227"
				+ "000000000010305230" + "000000000010305231" + "000000000010309416" + "000000000010309848" + "000000000010301914" + "000000000010301948"
				+ "000000000010300775" + "000000000010300780" + "000000000010306776" + "000000000010301590" + "000000000010304676" + "000000000010302840"
				+ "000000000010302841" + "000000000010305121" + "000000000010309802" + "000000000010309881" + "000000000010310032";

		return articoleExceptie.contains(codArticol);

	}	
	
	
}
