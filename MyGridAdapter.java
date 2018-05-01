package com.kottland.elab.recipeapphd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KottLand Lab on 6/16/2017.
 */

public final class MyGridAdapter extends BaseAdapter {

    private final List<Item>mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public String[] mRecipeTitle = {
           "Pancakes",
           "MINI HAM 'N' CHEESE",
           "Black Bean and Corn Quesadillas",
            "Lasagna",
            "Crepes",
            "Mango Citrus Drink",



    };

    public  String[] mDescriptionTXT = {

            "In a large bowl, sift together the flour, baking powder, salt and sugar. Make a well in the center and pour in the milk, egg and melted butter; mix until smooth.Heat a lightly oiled griddle or frying pan over medium high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. Brown on both sides and serve hot. ",
            "Preheat oven to 375°. In a bowl, whisk the first five ingredients until blended; stir in chives. Divide ham and cheese among eight muffin cups coated with cooking spray. Top with egg mixture, filling cups three-fourths full.Bake 22-25 minutes or until a knife inserted in the center comes out clean. Carefully run a knife around sides to loosen.",
            "Heat oil in a large saucepan over medium heat. Stir in onion, and cook until softened, about 2 minutes. Stir in beans and corn, then add sugar, salsa, and pepper flakes; mix well. Cook until heated through, about 3 minutes.Melt 2 teaspoons of the butter in a large skillet over medium heat. Place a tortilla in the skillet, sprinkle evenly with cheese, then top with some of the bean mixture. Place another tortilla on top, cook until golden, then flip and cook on the other side. Melt more butter as needed, and repeat with remaining tortillas and filling.",
            "In a Dutch oven, cook sausage, ground beef, onion, and garlic over medium heat until well browned. Stir in crushed tomatoes, tomato paste, tomato sauce, and water. Season with sugar, basil, fennel seeds, Italian seasoning, 1 tablespoon salt, pepper, and 2 tablespoons parsley. Simmer, covered, for about 1 1/2 hours, stirring occasionally.Bring a large pot of lightly salted water to a boil. Cook lasagna noodles in boiling water for 8 to 10 minutes. Drain noodles, and rinse with cold water. In a mixing bowl, combine ricotta cheese with egg, remaining parsley, and 1/2 teaspoon salt.Bake in preheated oven for 25 minutes. Remove foil, and bake an additional 25 minutes. Cool for 15 minutes before serving.",
            "In large bowl, whisk together eggs, milk, melted butter, flour sugar and salt until smooth.Heat a medium-sized skillet or crepe pan over medium heat. Grease pan with a small amount of butter or oil applied with a brush or paper towel. Using a serving spoon or small ladle, spoon about 3 tablespoons crepe batter into hot pan, tilting the pan so that bottom surface is evenly coated. Cook over medium heat, 1 to 2 minutes on a side, or until golden brown. Serve immediately.",
            "Process banana, lemon, mango, orange, apples, and ginger through juicer."
    };

    public static final String[] Ingredients =

            {
                    " 1 1/2 cups all-purpose flour, 3 1/2 teaspoons baking powder, 1 teaspoon salt, 1 tablespoon white sugar, 1 1/4 cups milk, 1 egg, 3 tablespoons butter, melted ",
                    "6 large eggs, 4 large egg whites, 2 tablespoons fat- free milk, 1/4 teasponn salt, 1/4 teaspoon pepper, 3 tablespoons minced fresh chives, 3.4 cup cubed fully cooked ham, 1 cup shrededd fat-free chedder cheese.",
                    "1 can black beans, drained and rinsed, 1 can whole kernel corn, drained, 1 tablespoon brown sugar, 1/4 cup salsa, 1/4 teaspoon red pepper flakes, 2 tablespoons butter, 8 flour tortillas, 1 1/2 cups shredded Morterey Jack cheese.",
                    "1 pound sweet Italian sauage, 3/4 pound lean ground beef, 1/2 cup minced onion, 2 cloves garlic, crushed, 1 can crushed tomatoes, 2 cans tomtato paste, 2 cans canned tomato sauce, 1.2 cup water, 2 tablespoons white sugar, 1 1/2 teaspoons dried basil leaves, 1.2 teaspoon fennel seeds.",
                    "1 cup all- purpose flour, 2 tablespoons white sugar, 1/2 teaspoon salt.",
                    "1 peeled banana, 1/2 peeled lemon, 1/2 mango - cut into wedges, 1/2 peeled orange, 2 appes cut into chuncks, 2 slices fresh ginger root.",
            };



    // Keep all Images in array
    public Integer[] mThumbIds = {


            R.drawable.appetizers, R.drawable.breakfast, R.drawable.lunch, R.drawable.dinner,
            R.drawable.dessert, R.drawable.drink,


    };


    public MyGridAdapter(Context context){
        mInflater = LayoutInflater.from(context);



        mItems.add(new Item("Appetizers", R.drawable.appetizers ) );  mItems.add(new Item("Breakfast", R.drawable.breakfast ) );
        mItems.add(new Item("Lunch", R.drawable.lunch ) );  mItems.add(new Item("Dinner", R.drawable.dinner ) );
        mItems.add(new Item("Dessert", R.drawable.dessert ) ); mItems.add(new Item("Drink", R.drawable.drink));


    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return mItems.get(i).drawableId;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View temp = view;
        ImageView picture;
        TextView name;
        if (temp==null){

            temp= mInflater.inflate(R.layout.grid_item, viewGroup, false);
            temp.setTag(R.id.picture, temp.findViewById(R.id.picture));
            temp.setTag(R.id.text,temp.findViewById(R.id.text));
        }

        picture = (ImageView)temp.getTag(R.id.picture);
        name = (TextView)temp.getTag(R.id.text);
        Item item = getItem(i);
        picture.setImageResource(item.drawableId);
        name.setText(item.name);
        return temp;

    }

    private static class Item {
        public final String name;
        public final  int  drawableId;
        Item(String name, int drawableId){
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
