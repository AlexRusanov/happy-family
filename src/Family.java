import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private int childCount;
    private Pet pet;

    static {
        System.out.println("Loading class:" + Family.class);
    }

    {
        System.out.println("Creating new instance of type " + this.getClass());
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[]{};
        this.childCount = 0;
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pet);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    public void addChild(Human child) {
        Human[] newChildrens = new Human[++childCount];
        System.arraycopy(children, 0, newChildrens, 0, children.length);
        children = newChildrens;
        children[childCount - 1] = child;
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        int result = children.length;
        
        if(childCount > 0) {
            Human[] newChildrens = new Human[--childCount];

            int j = 0;
            for (int i = 0; i < newChildrens.length; i++) {
                if(!children[i].equals(child)) {
                    newChildrens[i] = children[j];
                } else {
                    j++;
                    child.setFamily(null);
                }

                j++;
            }

            children = newChildrens;
        }

        result -= children.length;

        return (result == 1);
    }

    public int countFamily() {
        return 2 + children.length;
    }
}
