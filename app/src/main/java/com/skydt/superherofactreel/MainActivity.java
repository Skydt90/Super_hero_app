package com.skydt.superherofactreel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button btnNewHero;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvFact;

    private int lastHero;
    private int currentHero;
    private int nextHero;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadInterface();
    }

    private void loadInterface()
    {
        btnNewHero = findViewById(R.id.btnNewHero);
        btnNewHero.setOnClickListener(this);
        ivImage = findViewById(R.id.ivImage);
        tvTitle = findViewById(R.id.tvTitle);
        tvFact = findViewById(R.id.tvFact);

        lastHero = 0;
        currentHero = 0;
        nextHero = 0;
        random = new Random();
    }

    private String getHeroName(int index)
    {
        String[] names = {"Spider-Man", "Batman", "Iron Man", "Wonder Woman"};
        return names[index];
    }

    private int getHeroImage(int index)
    {
        Integer[] images = {R.drawable.spiderman, R.drawable.batman, R.drawable.ironman, R.drawable.wonderwoman};
        return images[index];
    }

    private String[] getHeroInfo(String name)
    {
        Map<String, String[]> heroFacts = new HashMap<>();

        String[] spiderman = {"\u2022 Hans rigtige navn er Peter Parker",
                "\n\u2022 Hans største fjender er Green Goblin og Venom",
                "\n\u2022 Hans spind opløses efter en time, men er stærkt nok til at holde Hulk",
                "\n\u2022 Han er den første teenage superhelt i verden",
                "\n\u2022 Introduceret i 1962, så han er teknisk set 57 år gammel",
                "\n\u2022 Han kan løfte 10 ton og kan svinge med en hastighed på 321 km/h"};

        String[] batman = {"\u2022 Hans rigtige navn er Bruce Wayne",
                "\n\u2022 Modsat andre superhelte har Batman ingen superkræfter",
                "\n\u2022 Hans største fjender er Jokeren og Ra's al Ghul",
                "\n\u2022 Introduceret i 1939, så han er teknisk set 80 år gammel",
                "\n\u2022 Han benytter sig af sin intellekt, rigdom og teknologi, til at bekæmpe skurke",
                "\n\u2022 Han er en af de eneste superhelte, der ved hvordan man besejrer Superman"};

        String[] ironman = {"\u2022 Hans rigtige navn er Tony Stark",
                "\n\u2022 Han har selv bygget sin dragt",
                "\n\u2022 Han har ingen superkræfter uden sin dragt",
                "\n\u2022 Tony Stark er baseret på en rigtig millionær ved navn Howard Hughes",
                "\n\u2022 Han har bygget specielle dragter, så han kan flyve i rummet eller svømme i havet",
                "\n\u2022 Hans største fjerne er Mandarinen"};

        String[] wonderwoman = {"\u2022 Hendes rigtige navn er Prinsesse Diana",
                "\n\u2022 Hun er en Amazone kriger fra en Ø bestående kun af kvinder",
                "\n\u2022 Hun er blandt de stærkeste helte i DC universet, på niveau med Superman",
                "\n\u2022 Hun kan flyve, er ekspert i kampsport og kan tale med dyr",
                "\n\u2022 Hendes armbånd er lavet fra resterne af Zeus's skjold og kan ikke gå i stykker"};

        heroFacts.put("Spider-Man", spiderman);
        heroFacts.put("Batman", batman);
        heroFacts.put("Iron Man", ironman);
        heroFacts.put("Wonder Woman", wonderwoman);

        return heroFacts.get(name);
    }

    @Override
    public void onClick(View v)
    {
        tvFact.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

        while (currentHero == nextHero || nextHero == lastHero)
        {
           nextHero = random.nextInt(4);
        }
        lastHero = currentHero;
        currentHero = nextHero;

        tvTitle.setText(getHeroName(nextHero));
        ivImage.setImageResource(getHeroImage(nextHero));

        String[] heroFacts = getHeroInfo(getHeroName(nextHero));
        tvFact.setText(heroFacts[0]);
        for (int i = 1; i < heroFacts.length; i++)
        {
            tvFact.append(heroFacts[i]);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }
}
