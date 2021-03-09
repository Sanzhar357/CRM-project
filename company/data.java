private static void EnsureDirectoryExists(string filePath) 
{ 
  FileInfo fi = new FileInfo(filePath);
  if (!fi.Directory.Exists) 
  { 
    System.IO.Directory.CreateDirectory(fi.DirectoryName); 
  } 
}
