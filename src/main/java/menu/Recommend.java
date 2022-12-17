package menu;

import java.util.ArrayList;
import java.util.List;

public class Recommend {
    public void recommend(List<Coach> coachInfo){
        AddCategory addCategory = new AddCategory();
        List<Menu> menu = new ArrayList<>();
        menu = addCategory.add(menu);
        List<String> category = recommendCategory(menu);
        List<Result> result =  recommendFood(category,coachInfo,menu);

        for(int i=0; i<result.size(); i++){
            System.out.print("\n"+result.get(i).name);
            for(int j=0; j<5; j++){
                System.out.print(result.get(i).food.get(j)+" ");
            }
        }
    }
    public List<String> recommendCategory(List<Menu> menu){
        List<String> category = new ArrayList<>();
        for(int i=0; i<5; i++) {
            String categoryName = randomCategory(menu);
            if(validateCategory(category, categoryName)){
                i--;
                continue;
            };
            System.out.println(categoryName);
            category.add(categoryName);
        }
        return category;
    }

    public List<Result> recommendFood(List<String> category, List<Coach> coachInfo, List<Menu> menu){
        List<Result> result = new ArrayList<>();
        for (int j = 0; j < coachInfo.size(); j++) {
            List<String> menuList = new ArrayList<>();
            for(int i=0; i<5; i++) {
                String categoryName = category.get(i);
                String Menu = randomMenu(menu, categoryName,coachInfo.get(j).nonfood);
                menuList.add(Menu);
            }
            result.add(new Result(coachInfo.get(j).name,menuList));
        }
        return result;
    }
    public boolean validateCategory(List<String> category, String categoryName){
        int dup=0;
        for(int i=0; i<category.size(); i++){
            if(categoryName.equals(category.get(i))){
                dup++;
            }
        }
        if(dup>2){
            return true;
        }
        return false;
    }
    public String randomCategory(List<Menu> menu){
        Random random = new Random();
        return random.RandomCategory(menu);
    }
    public String randomMenu(List<Menu> menu,String Category,List<String> nonfood){
        Random random = new Random();
        return random.RandomMenu(menu,Category,nonfood);
    }
}
