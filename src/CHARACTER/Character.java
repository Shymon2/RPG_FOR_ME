package CHARACTER;

import MAP.Map;

public abstract class Character 
{
    private String Name;
    private int HP, maxHP;
    private int Attack;
    private int Defense;
    private int Range;
    private int x;
    private int y;

//------------------------------------------------------

    //Constructor
    public Character(String name, int maxhp, int atk, int def, int range, int x, int y)
    {
        this.Name = name;
        this.maxHP = maxhp;
        this.HP = this.maxHP;
        this.Attack = atk;
        this.Defense = def;
        this.Range = range;
        this.x = x;
        this.y = y;
    }


//--------------------------------------- Getter Methods --------------------------------------------------
    public int getX()
    {return this.x;}
    public int getY()
    {return this.y;}
    public int getMaxHp()
    {return this.maxHP;}
    public int getHP()
    {return this.HP;}
    public int getRange()
    {return this.Range;}
    public int getAttack()
    {return this.Attack;}
    public int getDefense()
    {return this.Defense;}
    public String getName()
    {return this.Name;}

//--------------------------------------- Setter Methods --------------------------------------------------
    public void setX(int x)
    {this.x = x;}
    public void setY(int y)
    {this.y = y;}
    public void setRange(int range)
    {
        if(range < 0)
        {
            this.Range = 0;
        }
        else
        {
            this.Range = range;
        }
    }
    public void setAttack(int attack)
    {
        if(attack < 0)
        {
            this.Attack = 0;
        }
        else
        {
            this.Attack = attack;
        }
    }
    public void setDefense(int defense)
    {
        if(defense < 0)
        {
            this.Defense = 0;
        }
        else
        {
            this.Defense = defense;
        }
    }
    public void setMaxHp(int maxHPtoSet)
    {                                                               
        if(maxHPtoSet < this.getHP())
        {
            this.HP = maxHPtoSet;
            this.maxHP = maxHPtoSet;
        }
        else
        {
            this.maxHP = maxHPtoSet;
        }
    }


//--------------------------------------- Other Useful Methods -------------------------------------
    public void heal(int hpToHeal)
    {
        int HP_afterHeal = this.HP + hpToHeal;

        if(HP < maxHP)          
        {
            if(HP_afterHeal >= maxHP)
            {
                HP = maxHP;
            }
            else
            {
                HP = HP_afterHeal;
            }
        }
    }
    public int takeDamage(int dmg)
    {
        int remainingHP = this.HP + this.Defense - dmg;
        if(remainingHP < 0)
        {
            this.HP = 0;
        }
        else
        {
            this.HP = remainingHP;
        }
        return (dmg - this.Defense) <= 0 ? 0 : (dmg - this.Defense);
    }
    

//----------------------------------------- Abstract Methods -----------------------------------
    public abstract String getMark();
    


//----------------------------------------- Moving Methods -----------------------------------------
//These methods let character actually move when character doesn't collide solid area or out of border after moving

    public void moveUp(Map map)
    {
        int dx = 0;
        int dy = - 1;

        if(map.validMove(this, dx, dy))
        {
            this.x += dx;
            this.y += dy;
        }      
    }

    public void moveDown(Map map)
    {
        int dx = 0;
        int dy = 1;

        if(map.validMove(this, dx, dy))
        {
            this.x += dx;
            this.y += dy;
        }  
    }
    
    public void moveLeft(Map map)
    {
        int dx = -1;
        int dy = 0;

        if(map.validMove(this, dx, dy))
        {
            this.x += dx;
            this.y += dy;
        }  
    }

    public void moveRight(Map map)
    {
        int dx = 1;
        int dy = 0;

        if(map.validMove(this, dx, dy))
        {
            this.x += dx;
            this.y += dy;
        }     
    }
    

    

   
    
}