package aQute.lib.osgi;

import java.io.*;

public class PreprocessResource extends AbstractResource {
    final Resource  resource;
    final Processor processor;

    public PreprocessResource(Processor processor, Resource r) {
        super(r.lastModified());
        this.processor = processor;
        this.resource = r;
        setExtra(resource.getExtra());
    }

    protected byte[] getBytes() throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(2000);
        OutputStreamWriter osw = new OutputStreamWriter(bout, Constants.DEFAULT_CHARSET);
        PrintWriter pw = new PrintWriter(osw);
        InputStream in = resource.openInputStream();
        try {
            BufferedReader rdr = new BufferedReader(new InputStreamReader(in,"UTF8"));
            String line = rdr.readLine();
            while (line != null) {
                line = processor.getReplacer().process(line);
                pw.println(line);
                line = rdr.readLine();
            }
            pw.flush();
            byte [] data= bout.toByteArray();
            return data;
                
        } finally {
            in.close();
        }        
    }
}
