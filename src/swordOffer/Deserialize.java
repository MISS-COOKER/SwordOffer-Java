package swordOffer;

/**
 * @Author Linton
 * @Date 2019/7/9 9:17
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.*;
public class Deserialize {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(12);
        TreeNode g = new TreeNode(16);

//        a.left = b; a.right = c; b.left = d; b.right = e;
//        c.right = g; c.left = f;
        a.left = b; b.left = c ; c.left = d;
        Deserialize deserialize = new Deserialize();
        String s = deserialize.Serialize(a);
        TreeNode t = deserialize.Deserialize(s);
        System.out.println();
    }

    StringBuffer str = new StringBuffer();
    int index = -1;

    //TreeNode node = null;
    String Serialize(TreeNode root) {
        //前序遍历序列化二叉树
        if(root == null) return null;
        preOder(root);
        //str.deleteCharAt(str.length()-1); ???
        String s = str.toString();
        return s;
    }
    //前序遍历
    public void preOder(TreeNode root){
        if(root == null){
            str.append("#,");
            return ;
        }
        str.append(root.val + ",");
        preOder(root.left);
        preOder(root.right);
    }

    // 反序列化二叉树（真麻烦）
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strr = str.split(",");
        return Deserialize1(strr);
    }

    TreeNode Deserialize1(String[] strr){
        index++;
        if(!strr[index].equals("#")){
            TreeNode node = new TreeNode(Integer.parseInt(strr[index]));
            node.left = Deserialize1(strr);
            node.right = Deserialize1(strr);
            return node;
        }
        return null;
    }
}

