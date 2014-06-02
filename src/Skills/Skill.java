/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skills;

import com.jme3.texture.Image;

/**
 *
 * @author Enyone
 */
public abstract class Skill {

    private Image skillIcon;
    private String name;
    private String description;
    private double cooldown;
    private String target;

    public Image getSkillIcon() {
        return skillIcon;
    }

    public void setSkillIcon(Image skillIcon) {
        this.skillIcon = skillIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    
    
    
}
