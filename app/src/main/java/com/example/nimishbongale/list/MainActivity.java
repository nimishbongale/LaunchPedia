package com.example.nimishbongale.list;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        productList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setNestedScrollingEnabled(false);

        productList.add(
                new Product(
                        "ICON Mission",
                        "Pegasus",
                        "Northrop Grumman",
                        "Oct 26 2018   1:25 PM",
                        R.drawable.northrop,
                        "The Ionospheric Connection Explorer (ICON) is a satellite designed to investigate changes in the Earth's ionosphere. It is scheduled to by launched aboard a Pegasus XL rocket on October 26th 2018 as part of NASA's Explorers program and operated by UC Berkeley's Space Sciences Laboratory. ICON will study the interaction between Earth's weather systems and space weather driven by the Sun, and how this interaction drives turbulence in the upper atmosphere. It is hoped that a better understanding of this dynamic will mitigate its effects on communications, GPS signals, and technology in general."
                        , R.drawable.pegasus, "https://www.google.co.in/maps/place/Berkeley,+CA,+USA/@37.8739052,-122.3451428,12z/data=!4m5!3m4!1s0x808579363a8549d3:0x94ea1595a675e993!8m2!3d37.8715926!4d-122.272747", "https://www.nasa.gov/icon"));

        productList.add(
                new Product(

                        "Weilai 1 (CCTV)",
                        "Zhuque-1",
                        "LandSpace",
                        "Oct 27 2018         TBD",
                        R.drawable.landspace,
                        "Emerging private Chinese company Landspace is set to launch its first rocket into orbit in the final quarter of 2018, carrying a small satellite for a state television company. Landspace announced Aug. 2 that the three-stage solid-propellant LandSpace rocket, named Zhuque-1, will carry the China Central Television (CCTV) satellite for space science experiments and remote sensing before the end of the year."
                        , R.drawable.zhuqueone, "https://www.google.co.in/maps/place/Ejin,+Alxa,+Inner+Mongolia,+China/@41.6944461,99.3830733,8z/data=!4m5!3m4!1s0x37cd1072b2624d07:0x1a9c27e3825c7e16!8m2!3d41.958541!4d101.068933", "https://spacenews.com/landspace-of-china-to-launch-first-rocket-in-q4-2018/"));

        productList.add(
                new Product(

                        "GOSAT - 2",
                        "H2A",
                        "JAXA",
                        "Oct 29 2018  09:38 AM",
                        R.drawable.jaxa, "The increase of the atmospheric concentration of greenhouse gases such as carbon dioxide (CO2) and methane (CH4) is thought to be one of the major factors affecting the earth's climate and various activities to monitor concentrations of these gases have been conducted in many countries. However, the geographical inhomogeneity and lack of greenhouse gas measurement stations are ongoing cause of the large uncertainty in the estimated fluxes of these gases.",
                        R.drawable.htwoa, "https://www.google.co.in/maps/place/Tanega+Island+Space+Center+•+Space+Science+Museum/@30.37474,130.9577606,18z/data=!4m12!1m6!3m5!1s0x353cf2acbf51a1d9:0xe41d40b31890ec74!2sTanega+Island+Space+Center+•+Space+Science+Museum!8m2!3d30.37474!4d130.957453!3m4!1s0x353cf2acbf51a1d9:0xe41d40b31890ec74!8m2!3d30.37474!4d130.957453", "http://www.gosat-2.nies.go.jp/about/mission/"));

        productList.add(
                new Product(

                        "CFOSAT",
                        "LongMarch 2c",
                        "China (CNSA)",
                        "Oct 29 2018        TBD",
                        R.drawable.chinanational, "CFOSAT is a joint mission of the Chinese (CNSA) and French (CNES) space agencies with the goal to monitor the ocean surface winds and waves and to provide information on related ocean and atmospheric science and applications. The primary objective of CFOSAT is to monitor on a global scale the wind and waves at the ocean surface in order to improve.",
                        R.drawable.longmarchtwoc, "https://www.google.co.in/maps/place/China+Jiuquan+Satellite+Launch+Center+in+Dunhuang+RTS+asked+the+Tin+House/@40.129998,94.6601913,17z/data=!3m1!4b1!4m5!3m4!1s0x37eac6b446758fd1:0x955b194331abe2da!8m2!3d40.129998!4d94.66238", "https://directory.eoportal.org/web/eoportal/satellite-missions/content/-/article/cfosat"));

        productList.add(
                new Product(

                        "Es'hail Sat",
                        "Falcon 9",
                        "SpaceX",
                        "Nov 14 2018        TBD",
                        R.drawable.spacex4, "Es’hailSat - Qatar Satellite Company - has announced that following international consultation, Space Exploration Technologies (SpaceX) has been selected to launch the company’s second satellite - Es’hail 2 - in the fourth quarter of 2016 on board a Falcon 9 rocket.",
                        R.drawable.falconnine, "https://www.google.co.in/maps/place/Kennedy+Space+Center/@28.5728722,-80.6511695,17z/data=!3m1!4b1!4m5!3m4!1s0x88e74b95a365c6fd:0x8b7339f246f869dd!8m2!3d28.5728722!4d-80.6489808", "https://www.gulf-times.com/story/421370/Es-hailSat-selects-SpaceX-to-launch-second-satelli"));


        productList.add(
                new Product(

                        "Spaceflight SSO-A (Sun Synch Express)",
                        "Falcon 9",
                        "SpaceX",
                        "Nov 20 2018  12:00 AM",
                        R.drawable.spacex4, "We’re conducting tests this week for our 2018 SSO-A mission aboard a Falcon 9. Our new Auburn, WA Integration facility allows us to build the SSO-A stack to full height (nearly 20 feet!) while we run tests with mass simulators (structures of the same weight and size of the satellites to be launched) attached. Actual integration of customer satellites will occur in a clean room built on site. When integration is complete, the stack will be disassembled carefully in sections for shipment down to Vandenberg Air Force Base, where it will be reassembled at the launch site.",
                        R.drawable.falconnine, "https://www.google.co.in/maps/place/Vandenberg+AFB,+CA,+USA/@34.7428737,-120.5845469,12z/data=!3m1!4b1!4m5!3m4!1s0x80ec17dd388ccd39:0x6738159f65a64f81!8m2!3d34.7582101!4d-120.5163949", "http://spaceflight.com/sso-a-mission-prep-at-auburn-integration-facility/"));


        productList.add(
                new Product(
                        "NROL 71",
                        "Delta IV Heavy",
                        "ULA",
                        "Nov 29                TBD",
                        R.drawable.ula, "The covert follow-on satellite program that will serve as a replacement to the nation’s surveillance “eyes” from space begins launching in 2018 from Vandenberg Air Force Base in California.",
                        R.drawable.deltaivheavy, "https://www.google.co.in/maps/place/Vandenberg+AFB,+CA,+USA/@34.7428737,-120.5845469,12z/data=!3m1!4b1!4m5!3m4!1s0x80ec17dd388ccd39:0x6738159f65a64f81!8m2!3d34.7582101!4d-120.5163949", "https://spaceflightnow.com/2015/05/01/next-round-of-u-s-optical-spy-satellites-to-start-launching-in-2018/"));


        productList.add(
                new Product(
                        "LauncherOne Flight 1",
                        "LauncherOne",
                        "Virgin Orbit",
                        "Nov 2018              TBD",
                        R.drawable.virginorbit, "Last week, Virgin Galactic continued to test the first stage engine of its air-launched LauncherOne. The NewtonThree (N3) engine recently completed a long-duration test at full thrust.",
                        R.drawable.launcherone, "https://www.google.co.in/maps/place/United+States/@36.2045159,-113.7614677,4z/data=!3m1!4b1!4m5!3m4!1s0x54eab584e432360b:0x1c3bb99243deb742!8m2!3d37.09024!4d-95.712891", "http://www.spaceflightinsider.com/missions/commercial/virgin-galactic-continues-test-launcherone-engine/#yevmvhvtCChfWrtO.99"));

       /* productList.add(
                new Product(
                        1,
                        "",
                        "",
                        "",
                        "",
                        R.drawable.spacex,"",
                        R.drawable.spacex,"",""));*/

        productList.add(
                new Product(
                        "It's Business Time",
                        "Electron",
                        "Rocket Lab",
                        "Nov 2018            TBD",
                        R.drawable.rocketlab, "US orbital launch provider Rocket Lab has today confirmed its next launch will be the company's first fully commercial flight. Two Lemur-2 cubesats for launch customer Spire Global will be on board the upcoming launch with the full manifest to be confirmed in coming weeks. The flight's name was put to a vote on social media, with \"It's Business Time\" coming out as a clear fan favorite and as a continuation of company's previous flight, \"It's a Test\" and \"Still Testing\".",
                        R.drawable.electron, "https://www.google.com/maps/search/LC-1,+Mahia+Peninsula+New+Zealand/@12.8873715,77.6326596,15z", "http://www.rocketlabusa.com/news/updates/its-business-time-at-rocket-lab/"));


        productList.add(
                new Product(
                        "GSAT 11",
                        "Ariane 2",
                        "Arianespace",
                        "Dec 04 2018       TBD",
                        R.drawable.arianespace, "The GSAT satellites are India's indigenously developed communications satellites, used for digital audio, data and video broadcasting. As of 30 March 2018, 18 GSAT satellites of ISRO have been launched out of which 13 satellites are currently in service.",
                        R.drawable.arianefive, "https://www.google.com/maps/place/Kourou,+French+Guiana/@4.9221592,-52.7908437,10.99z/data=!4m5!3m4!1s0x8d120a7d73441cc1:0x9229a3707004d5e1!8m2!3d5.0428499!4d-52.7884171", "https://en.wikipedia.org/wiki/GSAT"));

        productList.add(
                new Product(
                        "Chang'e 4 Lander/Rover",
                        "Long March 3b",
                        "China (CNSA)",
                        "Dec 08th 2018     TBD",
                        R.drawable.chinanational, "China is planning to launch its Chang'e-4 lander and rover spacecraft to the far side of the Moon in December, a top scientist in the country's lunar exploration programme has said.",
                        R.drawable.longmarchtwoc, "https://www.google.com/maps/place/China+Xichang+Satellite+Launch+Center/@27.8930867,102.2426833,17z/data=!3m1!4b1!4m5!3m4!1s0x36dde5784e538b15:0x6bca93a4262493f1!8m2!3d27.893082!4d102.244872", "https://gbtimes.com/change-4-far-side-of-the-moon-lander-and-rover-mission-to-launch-in-december"));

        productList.add(
                new Product(
                        "Soyuz MS-11",
                        "Soyuz FG",
                        "Roscosmos",
                        "Dec 2018          TBD",
                        R.drawable.roscosmos, "Soyuz MS-11 is a Soyuz spaceflight initially planned for December 2018.[1] It will transport three members of the Expedition 58 crew to the International Space Station. MS-11 will be the 140th flight of a Soyuz spacecraft. The crew will consist of a Russian commander, and an American and a Canadian flight engineer. The flight has been postponed indefinitely whilst an investigation is carried out into the launch failure of the previous Soyuz mission, Soyuz MS-10.",
                        R.drawable.soyuzfg, "https://www.google.com/maps/place/Baikonur+Cosmodrome/@45.9425696,63.3389963,11z/data=!4m8!1m2!2m1!1sLC-1,+Baikonur+Cosmodrome+Kazakhstan!3m4!1s0x0:0xfa47e4a76f02164d!8m2!3d45.9645751!4d63.3052397", "https://en.wikipedia.org/wiki/Soyuz_MS-11"));

        productList.add(
                new Product(
                        "Iridium NEXT",
                        "Falcon 9",
                        "SpaceX",
                        "Dec 30 2018  10:08 AM",
                        R.drawable.spacex4, "Iridium NEXT will dramatically enhance Iridium’s ability to meet the growing demand for global mobile communications on land, at sea and in the skies. Iridium enables partners to create innovative products and solutions that haven’t even been conceived of yet, made possible through the flexibility of Iridium’s network. Iridium NEXT will:Support more bandwidth and higher speeds for new products;Enable partner solutions on a scale not yet imagined;Provide service continuity and backwards compatibility;Support Aireon’s aircraft tracking service as well as other Hosted Payload missions.",
                        R.drawable.falconnine, "https://www.google.com/maps/place/Vandenberg+AFB+Space+Launch+Complex+4/@34.6325313,-120.615167,17z/data=!4m8!1m2!2m1!1sSLC-4E,+Vandenberg+AFB+california!3m4!1s0x0:0xb2890f36a4a066a3!8m2!3d34.6320222!4d-120.6106594", "https://www.iridium.com/network/iridium-next/"));

        productList.add(
                new Product(
                        "VCLS Elana/XIX",
                        "Electron",
                        "RocketLab",
                        "Dec 2018          TBD",
                        R.drawable.rocketlab, "Early this month, Rocket Lab performed a successful fit check of the CubeSat dispensers for the NASA Venture Class Launch Service flight of the CubeSat Launch Initiative Educational Launch of Nanosatellites (ELaNa) XIX mission. The fit check was carried out at Rocket Lab’s Huntington Beach payload integration cleanroom. Venture Class launches aim to provide dedicated launches for CubeSats that would normally fly as secondary payloads, enabling these science missions to get exactly where they need to go on orbit.",
                        R.drawable.electron, "https://www.google.com/maps/search/LC-1,+Mahia+Peninsula+New+Zealand/@-39.1646126,177.7709856,11z/data=!3m1!4b1", "https://www.rocketlabusa.com/news/updates/rocket-lab-completes-fit-check-for-nasa-vcls-elana-xix-mission/"
                ));

        productList.add(
                new Product(
                        "EMISAT",
                        "PSLV",
                        "ISRO",
                        "Dec 2018          TBD",
                        R.drawable.isro, "Satellite with Argos and Altika, is a co-operative scientific mission on Indian Mini satellite Bus IMS-2, a new spacecraft bus developed by ISRO which belongs to the 450kg class of satellites. The bus is designed with a modular approach with standard mechanical and electrical interfaces.The Satellite comprises of two sections- The bus module and Payload module. Bus module consists of Mainframe housing subsystems required to support the operation of the whole satellite in cluding payloads and Payload module houses the payloads. The bus has a capability of carrying payloads of mass up to 200kgs and can support a payload power of 250 watts continuous operation. It has data transmission capabilities in both S-band and X-band. SARAL spacecraft carries a Ka band altimeter Ocean studies and ARGOS, a data collection platform. Both payloads integrated into module by CNES space agency.",
                        R.drawable.pslv, "https://www.google.com/maps/place/Satish+Dhawan+Space+Centre/@13.7258705,80.2243658,17z/data=!3m1!4b1!4m5!3m4!1s0x3a4da27eef264eaf:0xe9dec0ba1d50651f!8m2!3d13.7258653!4d80.2265545", "https://en.wikipedia.org/wiki/Indian_Mini_Satellite_bus"));

        productList.add(
                new Product(
                        "Vector-R Orbital Flight 1 ",
                        "Vector R",
                        "Vector",
                        "Q4 2018           TBD",
                        R.drawable.vector, "Vector, a nanosatellite launch company comprised of new-space and enterprise software industry veterans from SpaceX, Virgin Galactic, McDonnell Douglas, Boeing, Sea Launch and VMware and Open Cosmos, a space mission provider, today announced an agreement to reserve five orbital launches between 2019 and 2023 on the Vector-R launch vehicle. The announcement comes in advance of Vector's first orbital launch in July.\n",
                        R.drawable.vectorr, "https://www.google.com/maps/search/Pacific+Spaceport+Complex+-+Alaska+Alaska,+United+States/@57.4390798,-152.3616339,15z/data=!3m1!4b1", "https://www.prnewswire.com/news-releases/vector-announces-five-orbital-launch-reservation-with-open-cosmos-300598391.html?tc=eml_cleartime"));

        /*productList.add(
                new Product(
                        "",
                        "",
                        "",
                        "",
                        R.drawable.spacex,"",
                        R.drawable.spacex,"",""));*/

        productList.add(
                new Product(
                        "Chandrayaan-2",
                        "GSLV-III",
                        "ISRO",
                        "Jan 30th 2019     TBD",
                        R.drawable.isro, "Chandrayaan 2 is India's second lunar exploration mission after Chandrayaan-1. Developed by the Indian Space Research Organisation (ISRO), the mission is planned to be launched to the Moon by a Geosynchronous Satellite Launch Vehicle Mark III (GSLV Mk III). It includes a lunar orbiter, lander and rover, all developed by India.",
                        R.drawable.gslviii, "https://www.google.com/maps/place/Satish+Dhawan+Space+Centre/@13.7258705,80.2243658,17z/data=!3m1!4b1!4m5!3m4!1s0x3a4da27eef264eaf:0xe9dec0ba1d50651f!8m2!3d13.7258653!4d80.2265545", "https://en.wikipedia.org/wiki/Chandrayaan-2"));

        productList.add(
                new Product(
                        "Crew Dragon Demo",
                        "Falcon 9",
                        "SpaceX",
                        "Jan 2019          TBD",
                        R.drawable.spacex4, "SpaceX has delayed by several months a pair of test flights of its Crew Dragon spacecraft being developed for NASA’s commercial crew program, in part because of a Falcon 9 pad explosion in September. A revised schedule released by NASA Dec. 12 stated that an uncrewed test flight of the spacecraft, previously scheduled for May 2017, is now planned for November 2017. A crewed test flight, carrying two NASA astronauts, has been delayed from August 2017 to May 2018.",
                        R.drawable.falconnine, "https://www.google.com/maps/place/Kennedy+Space+Center/@28.5728769,-80.6511695,17z/data=!3m1!4b1!4m5!3m4!1s0x88e74b95a365c6fd:0x8b7339f246f869dd!8m2!3d28.5728722!4d-80.6489808", "https://spacenews.com/spacex-delays-commercial-crew-demonstration-flights/"));

        productList.add(
                new Product(
                        "PSN VI & Spaceflight Rideshare",
                        "Falcon 9",
                        "SpaceX",
                        "Jan 2019          TBD",
                        R.drawable.spacex4, "China Great Wall Industry Corp. has clinched a contract with an Indonesian joint venture to build a replacement for a satellite that is running out of fuel early due to an underperformed Long March launch. Palapa Satelit Nusantara Sejahtera, a joint venture of Indosat Ooredoo and Pasifik Satelit Nusantara (PSN), signed the contract for Palapa-N1, a high-throughput Ku-band satellite with 10 Gbps of capacity here May 17 with Beijing-based CGWIC, a subsidiary of China Aerospace Science and Technology Corporation.",
                        R.drawable.falconnine, "https://www.google.com/maps/place/SpaceX+Launch+Complex+40/@28.5619842,-80.5793791,17z/data=!3m1!4b1!4m5!3m4!1s0x88e0bb1a0a9edd77:0x983d6a01a54ad7e5!8m2!3d28.5619795!4d-80.5771904", "https://spacenews.com/china-great-wall-industry-corp-lands-indonesian-commercial-satellite-order/"));

        productList.add(
                new Product(
                        "EUTELSAT 7c",
                        "Ariane 5",
                        "Arianespace",
                        "Q1 2019           TBD",
                        R.drawable.arianespace, "EUTELSAT 7C is a high-power broadcast satellite for markets in Africa, Europe, Middle East and Turkey. It will be located at Eutelsat’s 7° East position, one of Eutelsat’s fastest-growing video neighbourhoods, which already broadcasts over 500 TV channels, and serves anchor clients including Turkish pay-TV platform Digiturk, and Azam TV and Muvi TV platforms in Sub-Saharan Africa.",
                        R.drawable.arianefive, "https://www.google.com/maps/search/ELA-3,+Guiana+Space+Centre+French+Guiana/@5.2299952,-52.7817268,15z/data=!3m1!4b1", "https://www.eutelsat.com/en/satellites/EUTELSAT-7C.html"));


        productList.add(
                new Product(
                        "STP-2",
                        "Falcon Heavy",
                        "SpaceX",
                        "Q1 2019           TBD",
                        R.drawable.spacex4, "More than two dozen satellites from the U.S. military, NASA and research institutions will ride into orbit on SpaceX’s second Falcon Heavy rocket launch, a mission currently scheduled for liftoff in June, a military spokesperson said. The flight is one of three Falcon Heavy missions that could blast off in 2018, after a successful maiden test flight Feb. 6 and the launch of an Arabsat communications craft around the end of the year.",
                        R.drawable.falconheavy, "https://www.google.com/maps/place/Kennedy+Space+Center/@28.5728769,-80.6511695,17z/data=!3m1!4b1!4m5!3m4!1s0x88e74b95a365c6fd:0x8b7339f246f869dd!8m2!3d28.5728722!4d-80.6489808", "https://spaceflightnow.com/2018/03/01/rideshare-mission-for-u-s-military-confirmed-as-second-falcon-heavy-launch/"
                ));

        adapter=new ProductAdapter(this,productList);
        //adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        }


    private void filter(String text)
    {
        ArrayList<Product> filteredlist=new ArrayList<>();
        for(Product item:productList){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase()))
                filteredlist.add(item);
        }
        adapter.filterList(filteredlist);
    }
}
