#
# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = "puppetmodule-stdlib"

  s.version = "4.0.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Puppet Labs"]
  s.date = "2013-04-10"
  s.description = "Puppet Labs Standard Library module"
  s.email = "bruce.ashfield@gmail.com"
  s.executables = []
  s.files += Dir['lib/**/*.rb'] + Dir['manifests/**/*.pp'] + Dir['tests/**/*.pp'] + Dir['spec/**/*.rb']
  s.homepage = "https://github.com/puppetlabs/puppetlabs-stdlib"
  s.rdoc_options = ["--title", "Puppet Standard Library Module", "--main", "README.markdown", "--line-numbers"]
  s.require_paths = ["lib"]
  s.rubyforge_project = "puppetmodule-stdlib"
  s.summary = "This module provides a standard library of resources for developing Puppet Modules."

  if s.respond_to? :specification_version then
    s.specification_version = 3

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
    else
    end
  else
  end
end
