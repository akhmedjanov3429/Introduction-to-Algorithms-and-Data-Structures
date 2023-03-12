public class ImproveNo2Slash
{
    public static void main(String[] args)
    {
        
        String name= StdIn.readString() ;
		String out = "";
		int n = name.length();
		char [] c = name.toCharArray();
		for (int i = 1; i < n; i++)
		{
			if (c[i] == '/' && c[i-1] == '/')
				continue;
			else {
				if (i == 1) out += c[i-1];
				out += c[i];
			}
		}
		StdOut.println(out);

        return;}}