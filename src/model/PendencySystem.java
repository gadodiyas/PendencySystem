package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PendencySystem {
     Map<Integer, Entity> entities = new HashMap<>();
     Map<String, List<Integer>> inProgressEntities = new HashMap<>();


    public Entity startTracking(Entity entity, List<String> tags) {
        if(entities.containsKey(entity.id)) {
            throw new RuntimeException("tracking is already in progress for given id");
        }

        entities.put(entity.id, entity);
        entity.setTags(tags);
        //create keys for each hierarchy of given tags
        StringBuilder sb = new StringBuilder();
        for(String tag : tags){
            sb.append(tag);
            String key = sb.toString();
            if(!inProgressEntities.containsKey(key)){
                inProgressEntities.put(key, new ArrayList<>());
            }
            inProgressEntities.get(key).add(entity.id);
            sb.append(",");
        }
        return entity;

    }

    public int getCounts(List<String> tags) {
        int cnt = 0;
        String key = getKey(tags);
        if(inProgressEntities.containsKey(key)){
            cnt = cnt + inProgressEntities.get(key).size();
        }

        System.out.println("No of entities for tag: " + key + " is " + cnt);
        return cnt;


    }

    private String getKey(List<String> tags) {
        StringBuilder sb = new StringBuilder();
        for(String tag : tags){
            sb.append(tag);
            sb.append(",");

        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }

    public void stopTracking(int id) {
        if(!entities.containsKey(id)){
            throw new UnsupportedOperationException("No in-progress tracking for this id");
        }

        Entity entity = entities.remove(id);
        StringBuilder sb = new StringBuilder();
        for(String tag : entity.tags ) {
            sb.append(tag);
            String key = sb.toString();
            if(inProgressEntities.containsKey(key)){
                inProgressEntities.get(key).remove(Integer.valueOf(entity.id));
            }
            sb.append(",");

        }

    }
}
