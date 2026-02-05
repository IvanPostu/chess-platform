let 
  pkgs = import <nixpkgs> { config = { allowUnfree = false; }; };
  PROJECT_ROOT = builtins.toString ./.;
in
pkgs.mkShell {
  name = "app-shell";

  buildInputs = [
    pkgs.cmake
    pkgs.clang-tools
    pkgs.gcc13.cc
    pkgs.gcc13
    pkgs.jdk21
  ];

  LANG = "en_US.UTF-8";
  LC_ALL = "en_US.UTF-8";

  shellHook = ''
    export PROJECT_ROOT=${PROJECT_ROOT}

    export JAVA_HOME=${pkgs.jdk21}
    export PATH=${pkgs.jdk21}/bin:$PATH

    export C_INCLUDE_PATH=$JAVA_HOME/include:$C_INCLUDE_PATH
    export CPLUS_INCLUDE_PATH=$JAVA_HOME/include:$CPLUS_INCLUDE_PATH

    export C_INCLUDE_PATH=$PROJECT_ROOT/external/gsl/build:$C_INCLUDE_PATH
    export CPLUS_INCLUDE_PATH=$PROJECT_ROOT/external/gsl/build:$CPLUS_INCLUDE_PATH
  
    chmod -R +x ${PROJECT_ROOT}/scripts
    export PATH=${PROJECT_ROOT}/scripts:$PATH
  '';
}